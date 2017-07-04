package company.myUseful.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by OPER on 04.07.2017.
 */
public class RegExp5 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("e.+d"); //начинается на е, потом любая последовательность и кончается на d
        Matcher m = p.matcher("extend cup end table");

        while (m.find()){
            System.out.println("Совпадение: " + m.group()); //find() возвращает самую длинную последовательность! |-> ...<-|
                                                            // Т.е. он начинает с двух сторон смотреть - "строгое" совпадение
        }

        System.out.println();

        //квантор ? позволяет задать "нестрогое" совпадение |-> ... ->|
        p = Pattern.compile("e.+?d");
        m = p.matcher("extend cup end table");

        while (m.find()){
            System.out.println("Совпадение: " + m.group());
        }

    }
}
