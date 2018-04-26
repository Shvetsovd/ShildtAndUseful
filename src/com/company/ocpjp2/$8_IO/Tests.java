package company.ocpjp2.$8_IO;

import java.io.*;

/**
 * Created by user on 26.04.2018.
 */
public class Tests {
    public static void main(String[] args) {
        System.out.println(File.separatorChar); // '\'
        System.out.println(File.separator); // "\"

        System.out.println(File.pathSeparatorChar); // ';'
        System.out.println(File.pathSeparator); // ";"

        System.out.println(System.getProperty("file.separator")); // "\"
        System.out.println(System.getProperty("path.separator")); // ";"

        File f = new File("c:");
        System.out.println(f.exists()); //true
        System.out.println(f.isAbsolute()); // false
        System.out.println(f.isDirectory()); //true
        System.out.println(f.getAbsolutePath()); // "c:\"
        System.out.println(f.getParent()); //"null"
        System.out.println(f.getName()); // ""

        f = new File("c:\\"); // or f = new File("c:/");
        System.out.println(f.exists()); //true
        System.out.println(f.isAbsolute()); // true
        System.out.println(f.isDirectory()); // true
        System.out.println(f.getAbsolutePath()); // "c:\"
        System.out.println(f.getParent()); //"null"
        System.out.println(f.getName()); // ""

        f = new File("c:\\abc"); // not really exist
        System.out.println(f.exists()); //false
        System.out.println(f.isAbsolute()); // true
        System.out.println(f.isDirectory()); // false
        System.out.println(f.isFile()); // false
        System.out.println(f.getAbsolutePath()); // "c:\abc"
        System.out.println(f.getParent()); //"c:\"
        System.out.println(f.getName()); // "abc"

        f = new File("abc"); // not really exist
        System.out.println(f.exists()); //false
        System.out.println(f.isAbsolute()); // false
        System.out.println(f.isDirectory()); // false
        System.out.println(f.isFile()); // false
        System.out.println(f.getAbsolutePath()); // "E:\Data\IntellijIdeaProjects\ShildtAndUseful\abc"
        System.out.println(f.getParent()); //"null"
        System.out.println(f.getName()); // "abc"

        f = new File(".\\abc"); // not really exist
        System.out.println(f.exists()); //false
        System.out.println(f.isAbsolute()); // false
        System.out.println(f.isDirectory()); // false
        System.out.println(f.isFile()); // false
        System.out.println(f.getAbsolutePath()); // "E:\Data\IntellijIdeaProjects\ShildtAndUseful\.\abc"
        System.out.println(f.getParent()); //"."
        System.out.println(f.getName()); // "abc"

        f = new File("....\\abc"); // not really exist
        System.out.println(f.exists()); //false
        System.out.println(f.isAbsolute()); // false
        System.out.println(f.isDirectory()); // false
        System.out.println(f.isFile()); // false
        System.out.println(f.getAbsolutePath()); // "E:\Data\IntellijIdeaProjects\ShildtAndUseful\....\abc"
        System.out.println(f.getParent()); //"...."
        System.out.println(f.getName()); // "abc"

        f = new File("a\\b\\c\\d"); // not really exist
        System.out.println(f.exists()); //false
        System.out.println(f.isAbsolute()); // false
        System.out.println(f.isDirectory()); // false
        System.out.println(f.isFile()); // false
        System.out.println(f.getAbsolutePath()); // "E:\Data\IntellijIdeaProjects\ShildtAndUseful\a\b\c\d"
        System.out.println(f.getParent()); // "a\b\c"
        System.out.println(f.getName()); // "d"

    }
}

class BBB {
    public static void main(String[] args) {
        File parent;
        File child;

        parent = new File("abc");
        System.out.println(parent); // abc

        child = new File("abc", "cde");
        System.out.println(child); // abc\cde

        child = new File(parent, "cde");
        System.out.println(child); // abc\cde

        parent = null;
        child = new File(parent, "cde");
        System.out.println(child); // cde

    }
}

class FileUtilities {
    public static void main(String[] args) {
        /*File src = new File("c:\\abc"); // must exist and can have any contents
        File dst = new File("c:\\test\\abc-backup"); // not exist and have the same drive
        System.out.println(src.renameTo(dst)); //true
        System.out.println(src.renameTo(dst)); //false*/
        printFileTree(new File("c:\\Program Files\\Adobe"));
        Writer os;
    }

    private static boolean move(File src, File dst) {
        return src.renameTo(dst);
    }

    private static void printFileTree(File file) {
        System.out.println(file);
        if (file != null && file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                printFileTree(subFile);
            }
        }
    }
}

class UserInputTests {
    public static void main(String[] args) throws IOException {
        echo();
        inputToFile1();
        inputToFile2();
    }

    public static void echo() throws IOException {
        //Don't close System streams!
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = in.readLine();
            if (s.equalsIgnoreCase("exit")) {
                break;
            }
            out.write(s);
            out.newLine();
            out.flush();
        }
    }

    public static void inputToFile1() throws IOException {
        System.out.println("Write to file:");

        //Don't close System streams or IOException will throw on next System.in read!
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try (PrintWriter out = new PrintWriter("C:/UserInput.txt")) {
            for (int i = 0; i < 2; i++) {
                out.println(in.readLine());
            }
        }
    }

    public static void inputToFile2() throws IOException {
        System.out.println("Write to file:");

        //Don't close System streams!
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedWriter out = new BufferedWriter(new FileWriter("C:/UserInput.txt"))) {
            for (int i = 0; i < 2; i++) {
                out.write(in.readLine());
                out.newLine();
            }
        }
    }
}

class CopyUtilities {
    public static void main(String[] args) throws IOException {
        //copyFile(new File("d:/1.mp4"), new File("d:/1-copy.mp4")); //50MB
        //copyFileBuffered(new File("d:/1.mp4"), new File("d:/2-copy.mp4"));
        //copyDir(new File("d:/tmp/avito1"), new File("d:/tmp/backup1"));
        //releaseDir(new File("d:/tmp/1"));
    }

    private static void releaseDir(File file) {
        if (file == null){
            return;
        }
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                releaseDir(f);
                //f.delete();
            }
        }
    }

    public static void copyFile(File src, File dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
                out.flush();
            }
        }
        //245114ms for 50MB file
    }

    public static void copyFileBuffered(File src, File dst) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dst))) {
            byte[] buf = new byte[8 * 1024];
            int count = 0;
            while ((count = in.read(buf)) != -1) {
                out.write(buf, 0, count);
                out.flush();
            }
        }
        //108ms for 50MB file
    }

    public static void copyDir(File src, File dst) throws IOException {
        File nf = new File(dst, src.getName());

        if (src.isDirectory()) {
            nf.mkdirs();
            File[] subFiles = src.listFiles();
            if (subFiles != null && subFiles.length > 0) {
                for (File file : subFiles) {
                    copyDir(file, nf);
                }
            }
        } else if (src.isFile()) {
            copyFileBuffered(src, nf);
        }
    }
}
