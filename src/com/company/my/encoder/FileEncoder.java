package company.my.encoder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by user on 26.03.2018.
 */
public class FileEncoder {
    Path src;
    Path dst;
    Charset srcCharset;
    Charset dstCharset;

    List<String> data;

    public FileEncoder(Path src, Charset srcCharset, Path dst, Charset dstCharset) {
        this.src = src;
        this.srcCharset = srcCharset;
        this.dstCharset = dstCharset;
        this.dst = dst;
        readData();
    }

    public void convertTo(){
        readData();
        writeData();
    }

    private void readData() {
        try {
            data = Files.readAllLines(src,srcCharset);
        } catch (IOException e) {

        }
    }

    private void writeData() {
        try {
            Files.write(dst,data, dstCharset, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
