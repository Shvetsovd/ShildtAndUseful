package company.useful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by user on 10.04.2017.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 6, 8, 4, 3, 3, 1, 1, 4, 2, 121, 0, 15};
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    private static int[] bubbleSort(int[] a) {
        for (int n = 0; n < a.length; n++) {
            for (int i = 0; i < a.length - 1 - n; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i);
                }

            }
        }
        return a;
    }

    private static void swap(int[] a, int i) {
        int tmp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = tmp;
    }


}
