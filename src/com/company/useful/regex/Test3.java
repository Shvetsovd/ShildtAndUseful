package company.useful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class Test3 {
    public static void main(String[] args) {
        String s = "Java 1 2 3 Java";
        String patt = "Java";

        Pattern p = Pattern.compile(patt);
        Matcher m = p.matcher(s);

        while (m.find()){
            System.out.println("Подстрока по шаблону " + "\"" + patt +"\"" + " найдена на позиции: " + m.start());
        }
    }
}
