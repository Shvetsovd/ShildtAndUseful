package company.my.interview;


import java.util.Arrays;

/**
 * Created by user on 26.03.2018.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] a = {1,2, 3};
        printAllPermutations(a, a.length);
    }

    private static void printAllPermutations(int[] a, int length) {
        if (length == 1){
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = 0; i < length; i++) {
                swap(a, i, length -1);
                printAllPermutations(a, length - 1);
                swap(a, i, length -1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
