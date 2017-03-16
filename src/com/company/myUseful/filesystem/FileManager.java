package company.myUseful.filesystem;

import company.myUseful.annotations.*;


import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by shvetsovd on 15.03.2017.
 */
public class FileManager {
    private static int DEFAULT_BUFFER_SIZE = 8 * 1024;

    /**
     * Method getDirContent(...) returns an array of strings naming the files and directories in the
     * directory dirPath.
     */
    @CodeState(CODE.RELEASE)
    public static ArrayList<String>
    getDirContent(String dirPath) throws IOException {
        File rootDir = new File(dirPath).getCanonicalFile();

        if (rootDir.isDirectory() && rootDir.exists()) {
            return new ArrayList<String>(Arrays.asList(rootDir.list()));
        } else {
            throw new FileNotFoundException(dirPath + " is not directory");
        }
    }

    /**
     * Method getDirFullContent(...) returns an ArrayList of strings naming the files and directories
     * recursive including subdirectories content
     */
    @CodeState(CODE.RELEASE)
    public static ArrayList<String>
    getDirFullContent(String dirPath) throws IOException {
        return getDirFullContentRecursive(
                new File(dirPath).getCanonicalFile(),
                new ArrayList<String>()
        );
    }

    @CodeState(CODE.RELEASE)
    private static ArrayList<String>
    getDirFullContentRecursive(File root, ArrayList<String> dirContent) throws IOException {

        if (!root.exists()) {
            throw new FileNotFoundException(root + " no such file or directory");
        }

        dirContent.add(root.toString());

        if (root.isDirectory()) {

            File[] dirFiles = root.listFiles();
            for (File file : dirFiles) {
                getDirFullContentRecursive(file, dirContent);
            }
        }

        return dirContent;
    }

    /**
     * Method copyDir(...) copy all content from source to destination directories
     */
    @CodeState(CODE.RELEASE)
    public static void copyDir(String srcDir, String toDir) throws IOException {

        File src = new File(srcDir).getCanonicalFile();
        File dst = new File(toDir).getCanonicalFile();

        // Check paths
        checkDirectoryForExisting(src);
        checkDirectoryForExisting(dst);

        // Recursive copy dir
        copyDirRecursive(src, dst);

    }

    @CodeState(CODE.RELEASE)
    private static void copyDirRecursive(File src, File dst) throws IOException {
        File newFile = new File(dst, src.getName());

        if (src.isFile()) {

            System.out.println("Copying file:\t" + newFile);
            copyFile(src.toString(), newFile.toString());

        }
        if (src.isDirectory()) {

            System.out.println("Creating dir:>\t" + newFile);
            newFile.mkdir();
            File[] files = src.listFiles();
            for (File file : files) {
                copyDirRecursive(file, newFile);
            }

        }
    }

    /**
     * Method copyFile(...) copy file from src to dst with user defined buffer size.
     * Destination folder gotta exist and not contain the file with src file name.
     */
    @CodeState(CODE.RELEASE)
    public static void copyFile(String src, String dst, int bufSize) throws IOException {
        if (bufSize < 1) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
        File srcFile = new File(src).getCanonicalFile();
        File srcDir = new File(srcFile.getParent());

        File dstFile = new File(dst).getCanonicalFile();
        File dstDir = new File(dstFile.getParent());

        // Check src and dst path
        checkFileForExisting(srcFile);
        checkFileForNonExisting(dstFile);
        checkDirectoryForExisting(dstDir);

        // Copy files
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(srcFile), bufSize);
             BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dstFile), bufSize)) {

            byte[] buf = new byte[bufSize];
            int count;
            while ((count = fin.read(buf)) != -1) {
                fout.write(buf, 0, count);
            }
            fout.flush();
        }

    }

    /**
     * Method copyFile(...) file from src to dst with default buffer size.
     * Destination folder must be exist and not contain the file with src file name.
     */
    @CodeState(CODE.RELEASE)
    public static void copyFile(String src, String dst) throws IOException {
        copyFile(src, dst, DEFAULT_BUFFER_SIZE);
    }

    /**
     * Method zipFile(...) deflate a source file to zip-file with destination name.
     */
    @CodeState(CODE.DEVELOP)
    public static void zipFile(String src, String zipName, int bufSize) throws IOException {

        if (bufSize < 1) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }

        File srcFile = new File(src).getCanonicalFile();
        File dstFile = new File(zipName).getCanonicalFile();

        checkFileForExisting(srcFile);
        checkFileForNonExisting(dstFile);
        checkDirectoryForExisting(dstFile.getParentFile());

        try (ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(dstFile)))) {
            addToZip(srcFile, zout, bufSize);
        }
    }

    @CodeState(CODE.DEVELOP)
    public static void zipFile(String src, String zipName) throws IOException {
        zipFile(src, zipName, DEFAULT_BUFFER_SIZE);
    }

    @CodeState(CODE.DEVELOP)
    private static void addToZip(File src, ZipOutputStream zout, int bufSize) throws IOException {
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(src))) {

            ZipEntry NewEntry = new ZipEntry(src.getName());
            zout.putNextEntry(NewEntry);

            byte[] buf = new byte[bufSize];
            int count = 0;

            while ((count = fin.read(buf)) != -1) {
                zout.write(buf, 0, count);
            }
            zout.flush();
        }
    }

    @CodeState(CODE.DEBUG)
    public static void deleteFile(String filePath) throws IOException {
        deleteDir(filePath);
    }

    @CodeState(CODE.DEBUG)
    public static void deleteDir(String dir) throws IOException {
        File file = new File(dir).getCanonicalFile();
        if (!file.exists()) {
            throw new IOException(file + " no such file or directory");
        }
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File f : subFiles) {
                deleteDir(f.toString());
            }
        }
        if (!file.delete()) {
            throw new IOException("Error deleting " + file.toString() + ". Check permissions.");
        }
    }

    @CodeState(CODE.RELEASE)
    private static void checkFileForExisting(File file) throws FileNotFoundException {
        if (!file.isFile() || !file.exists()) {
            throw new FileNotFoundException(file + ": file does not exist");
        }
    }

    @CodeState(CODE.RELEASE)
    private static void checkFileForNonExisting(File file) throws FileAlreadyExistsException, FileNotFoundException {

        if (file.exists()) {
            throw new FileAlreadyExistsException(file + ": file is already exist");
        }
    }

    @CodeState(CODE.RELEASE)
    private static void checkDirectoryForExisting(File dir) throws FileNotFoundException {

        if (!dir.isDirectory() || !dir.exists()) {
            throw new FileNotFoundException("Directory name is incorrect");
        }
    }


}
