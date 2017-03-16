package company.myUseful.filesystem;

import company.myUseful.annotations.CODE;
import company.myUseful.annotations.CodeState;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;

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
        return getDirFullContentRecursive(dirPath, new ArrayList<String>());
    }

    @CodeState(CODE.RELEASE)
    private static ArrayList<String>
    getDirFullContentRecursive(String dirPath, ArrayList<String> dirContent) throws IOException {
        File root = new File(dirPath).getCanonicalFile();

        if (!root.exists()) {
            throw new FileNotFoundException(dirPath + " no such file or directory");
        }

        dirContent.add(root.toString());

        if (root.isDirectory()) {

            File[] dirFiles = root.listFiles();
            for (File file : dirFiles) {
                getDirFullContentRecursive(file.toString(), dirContent);
            }
        }

        return dirContent;
    }

    /**
     * Method copyDir(...) copy all content from source to destination directories
     */
    @CodeState(CODE.DEBUG)
    public static void copyDir(String srcDir, String toDir) throws IOException {

        File src = new File(srcDir).getCanonicalFile();
        File dst = new File(toDir).getCanonicalFile();

        // Check paths
        checkDirectoryForExisting(src);
        checkDirectoryForExisting(dst);

        // Recursive copy dir
        File[] srcFiles = src.listFiles();
        for (File file : srcFiles) {

            File newFile = new File(dst, file.getName());

            if (file.isDirectory()) {
                System.out.println("Creating dir:>\t" + newFile);

                newFile.mkdir();
                copyDir(file.toString(), newFile.toString());
            }
            if (file.isFile()) {
                System.out.println("Copying file:\t" + newFile);

                copyFile(file.toString(), newFile.toString());
            }
        }

    }

    /**
     * Method copyFile(...) copy file from src to dst with user defined buffer size.
     * Destination folder gotta exist and not contain the file with src file name.
     */
    @CodeState(CODE.RELEASE)
    public static void copyFile(String src, String dst, int bufSize) throws IOException {

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
    public static void zipFile(String src, String zipFile) throws IOException {
        File srcFile = new File(src);
        File srcFolder = new File(srcFile.getParent());

        File dstFile = new File(zipFile);
        File dstFolder = new File(dstFile.getParent());


    }

    @CodeState(CODE.DEBUG)
    private static void checkFileForExisting(File file) throws FileNotFoundException {
        if (!file.isFile() || !file.exists()) {
            throw new FileNotFoundException(file + ": File is not exist");
        }
    }

    @CodeState(CODE.DEBUG)
    private static void checkFileForNonExisting(File file) throws FileAlreadyExistsException, FileNotFoundException {

        if (file.exists()) {
            throw new FileAlreadyExistsException(file + ": file is already exist");
        }
    }

    @CodeState(CODE.DEBUG)
    private static void checkDirectoryForExisting(File dir) throws FileNotFoundException {

        if (!dir.isDirectory() || !dir.exists()) {
            throw new FileNotFoundException("Directory name is incorrect");
        }
    }


}
