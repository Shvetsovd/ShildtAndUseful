package company.myUseful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class Test2 {
    public static void main(String[] args) {

        String s = "Java";
        String pattern = "Java";
        System.out.println("\"" + s + "\"" +
                " full equlity to template \"" +
                pattern + "\":\t" +
                regexFullEquality(s, pattern));


        pattern = "[Java]";
        System.out.println("\"" + s + "\"" +
                " full equlity to template \"" +
                pattern + "\":\t" +
                regexFullEquality(s, pattern));

        pattern = "[Java]+";
        System.out.println("\"" + s + "\"" +
                " full equlity to template \"" +
                pattern + "\":\t" +
                regexFullEquality(s, pattern));

    }

    static boolean regexFullEquality(String src, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(src);

        return m.matches();
    }

    static boolean regexSubstringEquality(String src, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(src);

        return m.find();
    }
}
