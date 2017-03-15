package company.myUseful.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static company.myUseful.filesystem.FileManager.copyFile;
import static company.myUseful.filesystem.FileManager.getDirContent;
import static company.myUseful.filesystem.FileManager.getDirFullContent;

/**
 * Created by OPER on 15.03.2017.
 */
public class FileManagerTest {

    public static void main(String[] args) {
        //getDirContent_Test("C:/!BCP");
        //getDirFullContent_Test("C:/!BCP/123");
        copyFile_Test("C:/Temp/1.exe", "D:/Temp/2.exe");
    }

    private static void getDirFullContent_Test(String s) {
        try {
            ArrayList<String> content = getDirFullContent(s);
            for (String c : content) {

                File file = new File(c);
                if (file.isFile()) {
                    System.out.print("\t" + file.getName());
                } else {
                    System.out.print(c);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getDirContent_Test(String s) {
        try {
            ArrayList<String> files = getDirContent(s);
            System.out.println(s + " contains:");
            for (String file : files) {
                System.out.println("\t" + file);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyFile_Test(String src, String dst) {
        try {
            long start = System.currentTimeMillis();

            copyFile(src, dst);

            long stop = System.currentTimeMillis();

            System.out.println("Copy time: " + (stop - start) + "ms");
        } catch (IOException e) {
            System.out.println("Error copy " + src + " to " + dst + ": " + e.getMessage());
        }
    }

}
