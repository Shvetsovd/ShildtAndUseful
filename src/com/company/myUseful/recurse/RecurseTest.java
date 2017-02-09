package company.myUseful.recurse;

/**
 * Created by dmitry on 30.01.17.
 */
public class RecurseTest {
    public static void main(String[] args) {
        int a = 5;
        int arr[] = { 5, 2, 6, 8, 0, 3 };
        //System.out.println(sumDigitsRecurse(a));
        //System.out.println(fact(a));
        printArray(arr, arr.length);
    }
    public static int sumDigitsRecurse(int n){
        if (n == 0) return 0;

        return sumDigitsRecurse(n / 10 ) + n % 10;
    }
    public static int fact(int n){
        if (n == 1) return 1;

        return fact(n - 1) * n;
    }
    public static void printArray(final int[] arr, int length){
        if (length == 0) return;

        printArray(arr, length - 1);
        System.out.print(arr[length -1] + " ");
    }

}
