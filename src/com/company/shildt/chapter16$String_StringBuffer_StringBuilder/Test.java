package company.shildt.chapter16$String_StringBuffer_StringBuilder;

/**
 * Created by user on 11.05.2017.
 */
public class Test {
    public static void main(String[] args) {
        //0123456789...       20
        //This is a test string
        String test = "This is a test string";
        String result;

        System.out.println(test.length()); //21

        //substring(int beginIndex, int endIndex) - [beginIndex; endIndex)
        result = test.substring(0,3); // Thi
        result = test.substring(5,21); // is a test string

        result = test.replace("is", "**"); // Th** ** a test string
        result = test.replace(" ", "_"); // This_is_a_test_string

        System.out.println(result);
    }
}
