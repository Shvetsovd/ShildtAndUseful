package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder;

/**
 * Created by user on 11.05.2017.
 */
public class Test {
    public static void main(String[] args) {
        //0123456789...       20
        //This is a test string
        String s = "This is a test string";
        String result;

        result = s.substring(5);
        System.out.println(result);

        result = s.substring(0, 3);
        System.out.println(result);

        result = s.substring(5, 11);
        System.out.println(result);


    }
}
