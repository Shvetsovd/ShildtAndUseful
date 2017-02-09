package company.myUseful.tmp;

/**
 * Created by dmitry on 30.01.17.
 */
public class RecursionTest {
    public static void main(String[] args) {

        printN(10);
        System.out.println();
        System.out.println(digitsSum(125));
    }

    public static void printN(int n){
        if (n == 0) return;
        printN(n - 1);

        System.out.print(n + " ");
    }

    public static int digitsSum(int n){

        if (n == 0) return 0;
        return n % 10 + digitsSum(n / 10);

    }
}
