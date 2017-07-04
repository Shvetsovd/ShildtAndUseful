package company.myUseful.regex;

import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp8 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[ ,.;!]+");
        String[] s = p.split("one two, three; four!five");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
