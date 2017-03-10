package company.shildt.chapter13;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by OPER on 10.03.2017.
 */
public class PrintWriterDemo {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out, true);

        pw.println("Это строка");
        pw.println(-7);
        double d = 4.5E-7;
        pw.println(d);

    }
}
