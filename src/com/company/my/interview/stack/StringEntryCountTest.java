package company.my.interview.stack;

/**
 * Created by user on 24.03.2018.
 */
public class StringEntryCountTest {
    public static void main(String[] args) {
        int count = getEntryCount("ab", "fdababnhjhabnhab");
        System.out.println(count);
    }

    private static int getEntryCount(String entry, String src) {
        int count = 0;
        int pos = 0;
        while ((pos = src.indexOf(entry, pos)) != -1){
            count++;
            pos++;
        }
        return count;
    }
}
