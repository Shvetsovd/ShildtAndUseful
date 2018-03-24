package company.my.interview;

import java.util.Arrays;

/**
 * Created by user on 22.03.2018.
 */
public class Sorts {
    public static void main(String[] args) {
        int[] a = {10, 7, 12, 0, -5, 50, 45};

        //bubbleSort(a);
        //selectionSort(a);
        insertionSort(a);
        //quickSort(a, 0, a.length - 1);
        //mergeSort(a, 0, a.length);

        System.out.println(Arrays.toString(a));

    }

    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }


    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    swap(a, i, j);
                }
            }
        }
    }

    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void quickSort(int[] a, int start, int end) {
        int l = start;
        int r = end;
        int m = l + (r - l) / 2;

        while (l <= r) {
            while (a[l] < a[m]) {
                l++;
            }
            while (a[r] > a[m]) {
                r--;
            }
            if (l <= r) {
                swap(a, l++, r--);
            }
        }
        if (l < end) {
            quickSort(a, l, end);
        }
        if (r > start) {
            quickSort(a, start, r);
        }
    }

    private static void mergeSort(int[] a, int start, int end) {
        int l = start;
        int r = end;

        if (r - l > 1) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m, r);

            int[] buf = new int[r - l];
            int indxL = l;
            int indxR = m;

            for (int i = 0; i < buf.length; i++) {
                if (a[indxL] < a[indxR]) {
                    buf[i] = a[indxL++];
                } else {
                    buf[i] = a[indxR++];
                }
                if (indxL == m && indxR < r){
                    System.arraycopy(a, indxR, buf, i+1, r - indxR);
                    break;
                }
                if (indxR == r && indxL < m){
                    System.arraycopy(a, indxL, buf, i+1, m - indxL);
                    break;
                }
            }
            System.arraycopy(buf, 0, a, l, buf.length);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
