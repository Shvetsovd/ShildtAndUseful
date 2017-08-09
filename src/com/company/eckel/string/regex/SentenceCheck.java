package company.eckel.string.regex;

public class SentenceCheck {
    public static void main(String[] args) {
        String s1 = "Strike while the iron is hot.";
        //String s1 = "Strike while the iron is hot";
        //String s1 = "strike while the iron is hot.";
        System.out.println(s1.matches("^\\p{Lu}.*[.?!]$"));
    }
}
