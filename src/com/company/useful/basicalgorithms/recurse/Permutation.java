package company.useful.basicalgorithms.recurse;

import java.util.Arrays;

/**
 * Created by OPER on 21.04.2017.
 */
public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        showAllPermutation(array, array.length);
    }

    private static void showAllPermutation(int[] array, int size) {
        if (size == 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = 0; i < size; i++) {
                swap(array, i, size - 1);
                showAllPermutation(array, size - 1);
                swap(array, i, size - 1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
