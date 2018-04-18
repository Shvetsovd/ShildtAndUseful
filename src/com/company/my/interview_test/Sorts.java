package company.my.interview_test;


import java.util.Arrays;

public class Sorts {
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }


    public static void quickSort(int[] a, int start, int end) {
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

    public static void mergeSort(int[] a, int start, int end) {
        int l = start;
        int r = end;

        if (r - l > 1) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m, r);

            int[] buf = new int[r - l];
            int i1 = l;
            int i2 = m;

            for (int i = 0; i < buf.length; i++) {
                if (a[i1] < a[i2]) {
                    buf[i] = a[i1++];
                } else {
                    buf[i] = a[i2++];
                }
                if ((i1 == m) && (i2 < r)) {
                    System.arraycopy(a, i2, buf, i + 1, r - i2);
                    break;
                }
                if ((i2 == r) && (i1 < m)) {
                    System.arraycopy(a, i1, buf, i + 1, m - i1);
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

    public static void main(String[] args) {
        int[] a = {10, 5, 17, 3, 25, 100, 14};
        //quickSort(a, 0, a.length - 1);
        mergeSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }
}
