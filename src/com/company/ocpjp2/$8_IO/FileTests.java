package company.ocpjp2.$8_IO;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by user on 18.04.2018.
 */
public class FileTests {
    public static void main(String[] args){
        File f = new File("E:/foo/baz");
        System.out.println(">File = " + f + "\n");
        getFileInfo(f);
        System.out.println(f + " mkDirs = " + f.mkdirs() + "\n");
        f = new File("E:/foo/baz/1.txt");
        System.out.println(">File = " + f + "\n");

        try {
            System.out.println("createNewFile = " + f.createNewFile() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        getFileInfo(f);
    }

    private static void getFileInfo(File f) {
        System.out.println("Path = " + f);
        System.out.println("exist = " + f.exists());
        System.out.println("isAbsolute = " + f.isAbsolute());
        System.out.println("getAbsolutePath = " + f.getAbsolutePath());
        System.out.println("isDirectory = " + f.isDirectory());
        System.out.println("isFile = " + f.isFile());
        System.out.println("getName = " + f.getName());
        System.out.println("getParent = " + f.getParent());
        System.out.println("length = " + f.length());
        System.out.println("lastModified = " + f.lastModified());
        System.out.println(LocalDateTime.ofEpochSecond(f.lastModified() / 1000, 0, ZoneOffset.ofHours(3)));

        System.out.println();

    }
}
