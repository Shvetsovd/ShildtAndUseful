package company.useful.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static company.useful.filesystem.FileManager.*;

/**
 * Created by OPER on 15.03.2017.
 */
public class FileManagerTest {

    public static void main(String[] args) {
        //getDirContent_Test("D:/");
        //getDirFullContent_Test("D:\\!ХАМЕЛЕОН\\3. МАКЕТЫ\\");

        //copyFile_Test("C:/Temp/PhotoshopCS5.exe", "D:/Temp/PhotoshopCS5.exe");
        copyDir_Test("c:/!BCP/123/", "D:/Temp/");

        //zipFile_Test("C:/Temp/info.log", "D:/Temp/info.zip");
        //zipDir_Test("C:/Temp", "D:/Temp/2.zip");
        //zipDir_Test("C:/!BCP/123/", "D:/Temp/1.zip");

        //unzip_Test("D:/Temp/info.zip", "C:/Temp/unzip");
        //unzip_Test("D:/Temp/1.zip", "C:/Temp/unzip");

        //deleteFile_Test("D:/Temp/1.zip");
        //deleteDir_Test("D:/Temp/123/");


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

    private static void unzip_Test(String zipPath, String dstDir){
        try {
            System.out.println("Start zip-extracting\n" +
                    "\t" + zipPath + " ---> " + dstDir + "\n");
            long start = System.currentTimeMillis();

            unzip(zipPath, dstDir);

            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void zipDir_Test(String dirPath, String zipName) {
        try {
            System.out.println("Start zipping directory:\n"
                    + "\t" + dirPath + "   --->   " + zipName + "\n");

            long start = System.currentTimeMillis();
            zipDir(dirPath, zipName);
            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDir_Test(String dirPath) {


        try {
            System.out.println("Deleting directory\n" + "\t" + dirPath);
            long start = System.currentTimeMillis();
            deleteDir(dirPath);
            long end = System.currentTimeMillis();
            System.out.println("\nFinished in " + (end - start) + "ms\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void deleteFile_Test(String filePath) {
        try {
            System.out.println("Deleting file\n" + "\t" + filePath);

            long start = System.currentTimeMillis();

            deleteFile(filePath);

            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFile_Test(String src, String zipName) {
        try {
            System.out.println("Start zipping file\n" +
                    "\t" + src + " ---> " + zipName);
            long start = System.currentTimeMillis();

            zipFile(src, zipName);

            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms\n---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir_Test(String srcDir, String dstDir) {
        try {
            System.out.println("Start copying...\n" + srcDir + " ---> " + dstDir + "\n");
            long start = System.currentTimeMillis();

            copyDir(srcDir, dstDir);

            long end = System.currentTimeMillis();

            System.out.println("\nFinished in " + (end - start) + "ms\n---");
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

            System.out.println("\nFinished in " + (stop - start) + "ms\n---");
        } catch (IOException e) {
            System.out.println("Error copy " + src + " to " + dst + ":\n\t--->" + e.getMessage());
        }
    }

}
