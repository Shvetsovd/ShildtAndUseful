package company.eckel.containers;

public class StringEqualsTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";

        String[] strings = "Hello Hello".split(" ");
        System.out.println(s1 == s2);
        System.out.println(strings[0] == strings[1]);

        strings[0] = "Hello";
        strings[1] = "Hel" + "lo";
        System.out.println(strings[0] == strings[1]);
    }
}
