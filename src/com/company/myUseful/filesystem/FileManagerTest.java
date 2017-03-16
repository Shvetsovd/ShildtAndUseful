package company.myUseful.filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static company.myUseful.filesystem.FileManager.*;

/**
 * Created by OPER on 15.03.2017.
 */
public class FileManagerTest {

    public static void main(String[] args) {
        //getDirContent_Test("D:/");
        //getDirFullContent_Test("D:\\!ХАМЕЛЕОН\\3. МАКЕТЫ\\");
        //copyFile_Test("C:/Temp/PhotoshopCS5.exe", "D:/Temp/PhotoshopCS5.exe");
        //copyDir_Test("c:/!BCP/123/", "D:/Temp/");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //getDirContent_Test("D:\\");
                //getDirContent_Test("D:\\!ХАМЕЛЕОН\\");

                //getDirFullContent_Test("D:\\MUSIC\\");

                //copyFile_Test("D:\\VIDEO\\vinylshakers-One night in Bangkok360.mp4", "E:/Temp/vinylshakers-One night in Bangkok360.mp4");

                //copyFile_Test("D:\\VIDEO\\InterStellar.avi", "E:/Temp/InterStellar.avi");

                //copyDir_Test("D:\\Test\\", "E:/Temp/Test");
                //copyDir_Test("D:\\Учебля\\", "E:/Temp/");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void copyDir_Test(String srcDir, String dstDir) {
        try {
            System.out.println("Start copying...\n" + srcDir + " ---> " + dstDir + "\n");
            long start = System.currentTimeMillis();

            copyDir(srcDir, dstDir);

            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms");
        } catch (IOException e) {
            System.out.println("Error copy " + srcDir + " to " + dstDir + ":\n\t--->" + e.getMessage());
        }
    }

    private static void getDirFullContent_Test(String s) {
        try {
            ArrayList<String> content = getDirFullContent(s);
            for (String c : content) {

                File file = new File(c);
                if (file.isFile()) {
                    System.out.print("\t" + file.getName());
                } else {
                    System.out.print("<--- " + c + " --->");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getDirContent_Test(String s) {
        try {
            ArrayList<String> files = getDirContent(s);
            System.out.println(s + " --->");
            for (String file : files) {
                System.out.println("\t" + file);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void copyFile_Test(String src, String dst) {
        try {
            System.out.println("Copying...\n" + src + " ---> " + dst);
            long start = System.currentTimeMillis();

            copyFile(src, dst);

            long stop = System.currentTimeMillis();

            System.out.println("\nFinished in " + (stop - start) + "ms");
        } catch (IOException e) {
            System.out.println("Error copy " + src + " to " + dst + ":\n\t--->" + e.getMessage());
        }
    }

}
