package company.my.interview;


import java.util.Arrays;

/**
 * Created by user on 22.03.2018.
 */
public class Search {
    public static void main(String[] args) {
        int[] a = {-5, 0, 7, 10, 12, 45, 50};

        int pos = binarySearch(a, 10);
        System.out.println(pos);
    }

    private static int binarySearch(int[] a, int value) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (value > a[m]) {
                l = m + 1;
                continue;
            }
            if (value < a[m]) {
                r = m - 1;
                continue;
            }
            if (value == a[m]) {
                return m;
            }
        }
        return -1;
    }
}
