package company.useful.recurse;

/**
 * Created by OPER on 31.01.2017.
 */
public class RecursePrintArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        printArray(arr, arr.length);
        printArrayRev(arr, 0);
    }
    static void printArray(final int[] arr, int n){
        if (n == 0) return;
        printArray(arr, n - 1);

        System.out.println(arr[n - 1]);
    }
    static void printArrayRev(final int[] arr, int n){
        if (n == arr.length) return;
        printArrayRev(arr, n + 1);

        System.out.println(arr[n]);
    }
}
