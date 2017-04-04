package company.myUseful.tmp;

/**
 * Created by OPER on 04.04.2017.
 */
public class StringTests {
    public static void main(String[] args) {
        String str1 = "string";
        String str2 = "string";
        String str3 = new String("string");

        System.out.println("String1 = \"" + str1 + "\"" + "\n" +
                "String2 = \"" + str2 + "\"" + "\n" +
                "String3 = new String(\"" + str3 + "\")" + "\n");


        System.out.println("\"string\" == str1 is " + ("string" == str1));
        System.out.println("\"string\".equals(str1) is " + "string".equals(str1));
        System.out.println();
        System.out.println("str1 == str2 is " + (str1 == str2));
        System.out.println("str1.equals(str2) is " + str1.equals(str2));
        System.out.println();
        System.out.println("str1 == str3 is " + (str1 == str3));
        System.out.println("\"string\"==str3 is " + ("string" == str3));
        System.out.println("str1.equals(str3) is " + str1.equals(str3));
        System.out.println();

    }
}
