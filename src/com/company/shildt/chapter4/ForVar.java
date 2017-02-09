package company.shildt.chapter4;

/**
 * Created by user on 17.01.2017.
 */

public class ForVar {
    public static void main(String[] args) {
        int i;
        boolean done = false;

        i = 0;
        for ( ; !done; ){
            System.out.println("i равно " + i);
            if (i == 10) done = true;
            i++;
        }
    }
}
