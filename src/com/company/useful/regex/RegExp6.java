package company.useful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp6 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher("this is a test");

        while (m.find()){
            System.out.println("Совпадение: " + m.group());
        }
    }
}
