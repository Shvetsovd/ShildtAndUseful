package company.useful.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by OPER on 27.06.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //readFile1("C:/debug.txt");
        //readFile2("C:/debug.txt");
        //writeToFile("C:/1.txt");
        //writeToFile2("C:/1.txt");
        //copyFile("C:/1.txt", "C:/2.txt");
        //showDir("C:/!BCP");
        showDir2("C:/!BCP");
    }

    static void readFile1(String path) {

        //get Path to file
        Path file = Paths.get(path);

        //buffer for file data
        ByteBuffer buf;

        //open the channel for file
        try (SeekableByteChannel fChan = Files.newByteChannel(file, StandardOpenOption.READ);) {

            //allocate buffer
            buf = ByteBuffer.allocate(128);

            //cyclic read file data to buffer and print on console
            int count = 0;
            while ((count = fChan.read(buf)) != -1) {
                buf.rewind();
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf.get());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile2(String path) {
        Path file = Paths.get(path);
        MappedByteBuffer buf;

        try (FileChannel fChan = (FileChannel) Files.newByteChannel(file, StandardOpenOption.READ)) {
            long size = fChan.size();
            buf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, size);

            buf.rewind();

            for (int i = 0; i < size; i++) {
                System.out.print((char) buf.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeToFile(String path) {
        Path file = Paths.get(path);
        ByteBuffer buf;
        int bufSize = 26;

        try (FileChannel fChan = (FileChannel) Files.newByteChannel(file,
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {
            buf = ByteBuffer.allocate(bufSize);

            for (int i = 0; i < bufSize; i++) {
                buf.put((byte) ('A' + i));
            }

            buf.rewind();

            fChan.write(buf);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void writeToFile2(String path) {
        Path file = Paths.get(path);
        MappedByteBuffer buf;
        int bufSize = 26;

        try (FileChannel fChan = (FileChannel) Files.newByteChannel(file,
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {

            buf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, bufSize);

            for (int i = 0; i < bufSize; i++) {
                buf.put((byte) ('A' + i));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void copyFile(String src, String dst) {
        Path srcFile = Paths.get(src);
        Path dstFile = Paths.get(dst);

        try {
            Files.copy(srcFile, dstFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void showDir(String path) throws IOException {
        Path dir = Paths.get(path);

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });

    }

    static void showDir2(String path) {
        Path dir = Paths.get(path);

        try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir);){

            for (Path dirEntry : dirStream) {
                BasicFileAttributes attrs = Files.readAttributes(dirEntry, BasicFileAttributes.class);
                if(attrs.isDirectory()){
                    System.out.print("<DIR> ");
                    System.out.println(dirEntry);
                    showDir2(dirEntry.toString());
                } else {
                    System.out.print("      ");
                    System.out.println(dirEntry);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
