package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        double d = -9E100;
        long l = (long)d;
        int i = (int)d;
        short s = (short) d;
        char c = (char) d;
        byte b = (byte) d;

        System.out.println(l);
        System.out.println(i);
        System.out.println(s);
        System.out.println((int)c);
        System.out.println(b);


    }

}
