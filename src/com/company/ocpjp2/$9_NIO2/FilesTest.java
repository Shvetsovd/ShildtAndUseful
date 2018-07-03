package company.ocpjp2.$9_NIO2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 28.05.2018.
 */
public class FilesTest {

    public static void copy(Path src, Path dst) throws IOException {

        Files.copy(src, dst);
        if (Files.isDirectory(src)) {
            Files.list(src).forEach(p -> {
                Path subPath = src.relativize(p);
                Path dstPath = dst.resolve(subPath);
                try {
                    copy(p, dstPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) throws IOException {
        Path src = Paths.get("e:\\tmp\\avito"); //exist
        Path dst = Paths.get("e:\\tmp1\\avito"); //not exist

        //copy file and dir (with contents)
        copy(src, dst);

        //print dir contents
        //Files.walk(src).forEach(System.out::println);

        //print only .jpg files
        /*Files.walk(src)
                .filter(p -> p.toString().endsWith(".jpg"))
                .forEach(System.out::println);*/

        //print .jpg files in root directory
        /*Files.find(src, 1, (p, a) -> p.toString().endsWith(".jpg"))
                .forEach(System.out::println);*/

        //print contents all .txt files
        /*Files.walk(src)
                .filter(p -> p.toString().endsWith(".txt"))
                .forEach(p -> {
                    System.out.println("<FILE_NAME>" + p.getFileName() + "</FILE_NAME>");
                    System.out.println("<CONTENT>");
                    try {
                        Files.lines(p)
                                .forEach(System.out::println); //!
                        *//*Files.lines(p, Charset.defaultCharset())
                                .forEach(System.out::println);*//*
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("</CONTENT>");
                });*/
    }


}
