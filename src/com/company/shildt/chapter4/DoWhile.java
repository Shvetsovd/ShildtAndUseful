package company.shildt.chapter4;

/**
 * Created by user on 16.01.2017.
 */

public class DoWhile {
    public static void main(String[] args) {
        int n = 10;

        do{
            System.out.println("такт " + n);
        }while (--n > 0);
    }
}
