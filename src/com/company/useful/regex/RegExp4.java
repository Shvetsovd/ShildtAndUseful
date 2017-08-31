package company.useful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp4 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("W+");
        Matcher m = p.matcher("W WW WWW");

        while (m.find()){
            System.out.println("Совпадение: " + m.group());
        }
    }
}
