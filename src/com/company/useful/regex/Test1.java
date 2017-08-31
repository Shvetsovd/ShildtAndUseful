package company.useful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class Test1 {
    public static void main(String[] args) {
        Pattern pat;
        Matcher match;
        boolean found;

        String s = "Java";
        String template = "Java";

        pat = Pattern.compile(template);
        match = pat.matcher(s);
        found = match.matches(); //полное совпадение с шаблоном

        if (found){
            System.out.println("Строка \"" + s + "\" соответствует шаблону \"" + template + "\"");
        } else {
            System.out.println("Строка \"" + s + "\" не соответствует шаблону \"" + template + "\"");
        }

        System.out.println();

        s = "Java 8";
        match = pat.matcher(s);
        found = match.matches(); //полное совпадение с шаблоном

        if (found){
            System.out.println("Строка \"" + s + "\" соответствует шаблону \"" + template + "\"");
        } else {
            System.out.println("Строка \"" + s + "\" не соответствует шаблону \"" + template + "\"");
        }

        System.out.println();

        found = match.find(); //имеется ли подстрока соответствующая шаблону

        if (found){
            System.out.println("Строка \"" + s + "\" содержит подстроку с шаблоном \"" + template + "\"");
        } else {
            System.out.println("Строка \"" + s + "\" не содержит подстроку с шаблоном \"" + template + "\"");
        }

        System.out.println();

        s = "Java ";
        match = pat.matcher(s);
        found = match.matches(); //полное совпадение с шаблоном

        if (found){
            System.out.println("Строка \"" + s + "\" соответствует шаблону \"" + template + "\"");
        } else {
            System.out.println("Строка \"" + s + "\" не соответствует шаблону \"" + template + "\"");
        }

        System.out.println();

        template = "Java\\s+";
        pat = Pattern.compile(template);
        s = "Java ";
        match = pat.matcher(s);
        found = match.matches();

        if (found){
            System.out.println("Строка \"" + s + "\" соответствует шаблону \"" + template + "\"");
        } else {
            System.out.println("Строка \"" + s + "\" не соответствует шаблону \"" + template + "\"");
        }
    }
}
