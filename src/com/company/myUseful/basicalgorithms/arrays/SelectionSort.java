package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by user on 19.04.2017.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {50, 30, 70, 20, 0, 80, 100, 10};
        System.out.println(Arrays.toString(a));
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }

            }

        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
