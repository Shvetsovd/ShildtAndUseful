package company.my.interview_test;

/**
 * Created by user on 15.04.2018.
 */
public class Search {
    public static int binarySearch(int[] a, int value) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (value < a[m]) {
                r = m - 1;
            } else if (value > a[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2};
        System.out.println(binarySearch(a, 2));
    }
}
