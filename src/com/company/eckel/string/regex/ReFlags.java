package company.eckel.string.regex;

/**
 * Created by user on 09.08.2017.
 */
//: strings/ReFlags.java
import java.util.regex.*;

public class ReFlags {
    public static void main(String[] args) {
        Pattern p =  Pattern.compile("^java",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while(m.find())
            System.out.println(m.group());
    }
} /* Output:
java
Java
JAVA
*///:~
