package company.ocpjp2.$8_IO;

import java.io.*;

/**
 * Created by user on 18.04.2018.
 */
public class StreamsMethods {
    public static void main(String[] args) throws IOException {
        String path1 = "E:/foo/baz/Letters.txt";
        String path2 = "E:/foo/baz/Letters-copy.txt";
        String data = "ABCDEFGHIKLMNOPQRSTVXYZ";

        FileManager.writeToFile(path1, data);
        FileManager.copyBuffered(path1, path2);
        FileManager.cyclicRead(path1, 2, 10, 3);
    }
}

class FileManager{
    public static void cyclicRead(String path, int offset, int length, int count) throws IOException {
        try(Reader in = new BufferedReader(new FileReader(path))){
            if (in.markSupported()){
                long skipped = in.skip(offset);
                for (int i = 0; i < count; i++) {
                    in.mark(length);
                    for (int j = 0; j < length; j++) {
                        System.out.print((char) in.read());
                    }
                    in.reset();
                    System.out.println();
                }
            }
        }
    }
    public static void writeToFile(String path, String data) throws IOException {
        try(Writer out = new BufferedWriter(new FileWriter(path))){
            out.write(data);
        }
    }
    public static void copyBuffered(String src, String dst) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dst))
        ){
            byte[] buf = new byte[1024];
            int count;
            while ((count = in.read(buf)) > 0){
                out.write(buf, 0, count);
            }
        }
    }
}
