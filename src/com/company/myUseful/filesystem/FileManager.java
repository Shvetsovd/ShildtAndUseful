package company.myUseful.filesystem;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OPER on 15.03.2017.
 */
public class FileManager {
    private static int DEFAULT_BUFFER_SIZE = 8 * 1024;


    /**
     * Method getDirContent returns an array of strings naming the files and directories in the
     * directory denoted by this abstract pathname.
     */
    public static ArrayList<String> getDirContent(String dir) throws FileNotFoundException {
        File rootDir = new File(dir);

        if (rootDir.isDirectory() && rootDir.exists()) {
            return new ArrayList<String>(Arrays.asList(rootDir.list()));
        } else {
            throw new FileNotFoundException(dir + " is not exist");
        }
    }

    /**
     * Method getDirFullContent returns an array of strings naming the files and directories
     * recursive including subdirectories content
     */
    public static ArrayList<String> getDirFullContent(String dir) throws FileNotFoundException {
        return getDirFullContentRecursive(dir, new ArrayList<String>());
    }

    private static ArrayList<String> getDirFullContentRecursive(String dir, ArrayList<String> content) throws FileNotFoundException {
        File root = new File(dir);
        if (!root.exists()) {
            throw new FileNotFoundException(dir + " no such file or directory");
        }

        content.add(root.toString());

        if (root.isDirectory()) {

            File[] dirFiles = root.listFiles();
            for (File file : dirFiles) {
                getDirFullContentRecursive(file.toString(), content);
            }
        }

        return content;
    }

    /**
     * Method copyFile copy file from src to dst with user defined buffer size.
     * Destination folder gotta exist and not contain the file with src file name.
     */
    public static void copyFile(String src, String dst, int bufSize) throws IOException {

        File srcFile = new File(src);
        File srcFolder = new File(srcFile.getParent());

        File dstFile = new File(dst);
        File dstFolder = new File(dstFile.getParent());

        // Check src and dst for path errors
        if (!srcFile.isFile() || !srcFile.exists()) {
            throw new FileNotFoundException("Source file is not exist");
        }

        if (dstFile.exists()) {
            throw new FileAlreadyExistsException("Destination file is already exist");
        } else {
            if (!dstFolder.isDirectory() || !dstFolder.exists()) {
                throw new FileNotFoundException("Destination folder is not valid");
            }
        }

        // Copy files
        try (BufferedInputStream fin = new BufferedInputStream(new FileInputStream(srcFile), bufSize);
             BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dstFile), bufSize)) {

            byte[] buf = new byte[bufSize];
            int count;
            while ((count = fin.read(buf)) != -1) {
                fout.write(buf, 0, count);
            }
            fout.flush();
        } catch (IOException e) {
            throw e;
        }


    }

    /**
     * This function copy file from src to dst with user default buffer size.
     * Destination folder gotta exist and not contain the file with src file name.
     */
    public static void copyFile(String src, String dst) throws IOException {
        copyFile(src, dst, DEFAULT_BUFFER_SIZE);
    }
}
