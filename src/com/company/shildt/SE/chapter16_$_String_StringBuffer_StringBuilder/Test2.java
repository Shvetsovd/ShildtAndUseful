package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder;

import company.myUseful.lambda.Test;
import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;


public class Test2 {

    static int a = 3;

    static {
        System.out.println("before" + a);
        a = 5;
        System.out.println("after" + a);
    }


    public static void main(String[] args) {

        byte a = -128;
        byte b = 100;
        byte c = (byte) (a << 1);
        System.out.println(c);
        //System.out.println(Test2.a);

    }


}



