package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "This is a test string";
        System.out.println(s.matches("\\d")); //false - цифра(один раз)
        System.out.println(s.matches("\\D?")); //false - не цифра(ноль или один раз)
        System.out.println(s.matches("\\D")); //false - не цифра(один раз)
        System.out.println(s.matches("\\D*")); //true - не цифра (ноль или много раз)
        System.out.println(s.matches("\\D+")); //true - не цифра (1 или много)
        System.out.println(s.matches("[A-z\\s]+")); //true - любая буква от A до z или пробел (один или много раз)
        System.out.println(s.matches("[\\w\\s]+")); //true - любая буква или пробел (один или много раз)
        System.out.println(s.matches("[\\s\\w]+")); //true - тоже самое, что и предыдущее
        System.out.println(s.matches("[^\\d э-я]+")); //true - не цифра и не э, ю, я (один или много раз)


    }

}
