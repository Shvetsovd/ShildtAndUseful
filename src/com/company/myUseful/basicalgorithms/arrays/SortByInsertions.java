package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by OPER on 10.04.2017.
 */
public class SortByInsertions {
    public static void main(String[] args) {
        int[] a = new int[]{50, 30, 60, 20, 0, 100, 150, -100, 80};
        System.out.println(Arrays.toString(a));

        sortByInsertions(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sortByInsertions(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
                swap2(a, j, j-1);
            }

        }
    }



    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void swap2(int[] a, int j, int i) {
        a[i] += a[j];
        a[j] = a[i] - a[j];
        a[i] -= a[j];
    }

}
