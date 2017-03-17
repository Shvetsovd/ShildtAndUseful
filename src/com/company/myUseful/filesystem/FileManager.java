package company.myUseful.filesystem;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import company.myUseful.annotations.*;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by shvetsovd on 15.03.2017.
 */
public class FileManager {
    private final static int DEFAULT_BUFFER_SIZE = 8 * 1024;

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

    @CodeState(CODE.DEBUG_BETA)
    private static void copyDirRecursive(File src, File dst) throws IOException {
        File newFile = new File(dst, src.getName());

        if (src.isDirectory()) {

            System.out.println("< " + newFile.getName() + " >");

            newFile.mkdir();
            File[] files = src.listFiles();
            for (File file : files) {
                copyDirRecursive(file, newFile);
            }

            //!
            System.out.println("< /" + newFile.getName() + " >");
        }

        if (src.isFile()) {

            //!
            System.out.println("|\t" + newFile.getName());
            copyFile(src.toString(), newFile.toString());

        }

    }

    /**
     * Method copyFile(...) copy file from src to dst with user defined buffer size.
     * Destination folder gotta exist and not contain the file with src file name.
     */
    @CodeState(CODE.RELEASE)
    public static void copyFile(String src, String dst, int bufSize) throws IOException {

        checkBuf(bufSize);

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
    @CodeState(CODE.RELEASE)
    public static void zipFile(String src, String zipName, int bufSize) throws IOException {

        checkBuf(bufSize);

        File srcFile = new File(src).getCanonicalFile();
        File dstFile = new File(zipName).getCanonicalFile();

        checkFileForExisting(srcFile);
        checkFileForNonExisting(dstFile);
        checkDirectoryForExisting(dstFile.getParentFile());

        try (ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(dstFile)))) {
            addFileToZip(srcFile, zout, null, bufSize);
        }
    }

    @CodeState(CODE.RELEASE)
    public static void zipFile(String src, String zipName) throws IOException {
        zipFile(src, zipName, DEFAULT_BUFFER_SIZE);
    }

    @CodeState(CODE.RELEASE)
    public static void zipDir(String src, String zipName, int bufSize) throws IOException {

        checkBuf(bufSize);

        File srcDir = new File(src).getCanonicalFile();
        File zipFile = new File(zipName).getCanonicalFile();

        checkDirectoryForExisting(srcDir);
        checkDirectoryForExisting(zipFile.getParentFile());
        checkFileForNonExisting(zipFile);

        try (ZipOutputStream zout =
                     new ZipOutputStream
                             (new BufferedOutputStream
                                     (new FileOutputStream(zipFile)))) {
            zipDirRecursive(srcDir, srcDir, zout, bufSize);
        }

    }

    @CodeState(CODE.RELEASE)
    public static void zipDir(String src, String zipName) throws IOException {
        zipDir(src, zipName, DEFAULT_BUFFER_SIZE);
    }

    @CodeState(CODE.DEBUG_BETA)
    private static void zipDirRecursive(final File root, File src, ZipOutputStream zout, int bufSize) throws IOException {
        if (src.isDirectory()) {
            System.out.println("< " + src.getName() + " >");

            File[] srcFiles = src.listFiles();

            for (File file : srcFiles) {
                zipDirRecursive(root, file, zout, bufSize);
            }
            //!
            System.out.println("< /" + src.getName() + " >");

        } else {
            Path file = Paths.get(src.toString());
            Path dir = Paths.get(root.getParent());
            Path zipPath = dir.relativize(file);

            ZipEntry zipEntry = new ZipEntry(zipPath.toString());

            //!
            System.out.println("|\t" + src.getName());

            addFileToZip(src, zout, zipEntry, bufSize);
        }


    }

    @CodeState(CODE.RELEASE)
    private static void addFileToZip(File src,
                                     @NotNull ZipOutputStream zout,
                                     @Nullable ZipEntry zipEntry,
                                     int bufSize) throws IOException {

        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(src))) {

            if (zipEntry == null) {
                zipEntry = new ZipEntry(src.getName());
            }
            zout.putNextEntry(zipEntry);

            byte[] buf = new byte[bufSize];
            int count = 0;

            while ((count = fin.read(buf)) != -1) {
                zout.write(buf, 0, count);
            }
            zout.flush();
        }
    }

    @CodeState(CODE.DEBUG)
    public static void unzip(String zipPath, String dstDir, int bufSize) throws IOException {

        checkBuf(bufSize);

        File zipFile = new File(zipPath).getCanonicalFile();
        File dst = new File(dstDir, getNameWithoutExt(zipFile, ".zip"));

        checkFileForExisting(zipFile);
        checkDirectoryForExisting(dst.getParentFile());

        try (ZipInputStream zin =
                     new ZipInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(zipFile)));

        ) {
            unzipFile(dst, zin, bufSize);
        }

    }

    @CodeState(CODE.DEBUG)
    private static String getNameWithoutExt(File zipFile, String ext) {
        String file = zipFile.getName();
        if (!file.endsWith(ext)) {
            throw new IllegalArgumentException(zipFile.toString() + " incorrect extension");
        }
        return file.substring(0, file.lastIndexOf('.'));

    }

    @CodeState(CODE.DEBUG)
    private static void unzipFile(File dst,
                                  @NotNull ZipInputStream zin,
                                  int bufSize) throws IOException {

        ZipEntry entry = zin.getNextEntry();
        if (entry == null) {
            return;
        }
        File dstFile = new File(dst, entry.getName());
        File dstFolder = new File(dstFile.getParent());
        if (!dstFolder.exists()) {
            dstFolder.mkdirs();
        }

        //!
        System.out.println("unzip ->\t" + dstFile);

        try (BufferedOutputStream fout =
                     new BufferedOutputStream(
                             new FileOutputStream(dstFile))) {
            int count;
            byte[] buf = new byte[bufSize];

            while ((count = zin.read(buf)) != -1) {
                fout.write(buf, 0, count);
            }

            fout.flush();
        }
        unzipFile(dst, zin, bufSize);
    }

    public static void unzip(String zipPath, String dstDir) throws IOException {
        unzip(zipPath, dstDir, DEFAULT_BUFFER_SIZE);
    }

    @CodeState(CODE.RELEASE)
    public static void deleteFile(String filePath) throws IOException {

        File file = new File(filePath).getCanonicalFile();
        checkFileForExisting(file);
        if (!file.delete()) {
            throw new IOException("Error deleting " + file.toString() + ". Check permissions.");
        }
    }

    @CodeState(CODE.RELEASE)
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

    @CodeState(CODE.RELEASE)
    private static void checkBuf(int bufSize) {
        if (bufSize < 1) {
            throw new IllegalArgumentException("Buffer size must be positive");
        }
    }

}
