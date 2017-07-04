package company.myUseful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp7 {
    public static void main(String[] args) {
        String s = "Jon Jonatan Mark Ken Todd";
        Pattern p = Pattern.compile("Jon.*? ");
        Matcher m = p.matcher(s);

        System.out.println("Исходная последовательность: " + s);
        s = m.replaceAll("Eric ");
        System.out.println("Измененная последовательность: " + s);

        System.out.println();

        s = "Jon Jonatan Mark Ken Todd";
        p = Pattern.compile("Jon.* ");
        m = p.matcher(s);

        System.out.println("Исходная последовательность: " + s);
        s = m.replaceAll("Eric ");
        System.out.println("Измененная последовательность: " + s);

    }
}
