package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by OPER on 10.04.2017.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{50, 30, 20, 90, 60, 10, 0, 100, -100};
        System.out.println(Arrays.toString(a));

        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {
        _quickSort(a, 0, a.length - 1);
    }

    private static void _quickSort(int[] a, int start, int end) {
        int l = start;
        int r = end;
        int bound = a[l + (r - l) / 2];
        while (l <= r) {
            while (a[l] < bound) {
                l++;
            }
            while (a[r] > bound) {
                r--;
            }
            if (l <= r) {
                swap(a, l++, r--);
            }
        }
        if (l < end) {
            _quickSort(a, l, end);
        }
        if (r > start) {
            _quickSort(a, start, r);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }






























/*    private static void _quickSort(int[] a, int start, int end) {
        int l = start;
        int r = end;

        int med = a[l + (r - l) / 2];

        while (l <= r) {
            while (a[l] < med) {
                l++;
            }
            while (a[r] > med) {
                r--;
            }
            if (l <= r) {
                swap(a, l++, r--);
            }
        }
        if (l < end) {
            _quickSort(a, l, end);
        }
        if (r > start) {
            _quickSort(a, start, r);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }*/


}
