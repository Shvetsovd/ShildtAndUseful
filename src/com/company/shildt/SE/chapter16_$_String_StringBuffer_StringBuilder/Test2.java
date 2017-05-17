package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("ABCDEF");

        System.out.println(sb.length()); //6
        System.out.println(sb.capacity()); //22

        sb.trimToSize();

        System.out.println(sb.length()); //6
        System.out.println(sb.capacity()); //6

    }

}
