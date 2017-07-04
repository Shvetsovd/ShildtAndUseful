package company.myUseful.regex;

import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp9 {
    public static void main(String[] args) {
        if(Pattern.matches(".*is.*", "This is a test string")){
            System.out.println("Строка соответствует шаблону");
        } else {
            System.out.println("Строка не соответствует шаблону");
        }

        System.out.println();

        String s = "This is a test string";
        if (s.matches(".*is.*")){
            System.out.println("Строка соответствует шаблону");
        } else {
            System.out.println("Строка не соответствует шаблону");
        }
    }
}
