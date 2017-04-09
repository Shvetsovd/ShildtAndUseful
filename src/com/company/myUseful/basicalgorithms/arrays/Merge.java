package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by user on 10.04.2017.
 */
public class Merge {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] b = {15, 18, 23, 35, 75, 90};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.toString(merge(a, b)));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aindex = 0;
        int bindex = 0;

        for (int i = 0; i < result.length; i++) {
            if (a[aindex] < b[bindex]) {
                result[aindex + bindex] = a[aindex++];
            } else {
                result[aindex + bindex] = b[bindex++];
            }
            if ((aindex == a.length) && (bindex < b.length)) {
                System.arraycopy(b, bindex, result, aindex + bindex, b.length - bindex);
                break;
            }
            if ((bindex == b.length) && (aindex < a.length)) {
                System.arraycopy(a, aindex, result, aindex + bindex, a.length - aindex);
                break;
            }

        }
        return result;
    }
}
