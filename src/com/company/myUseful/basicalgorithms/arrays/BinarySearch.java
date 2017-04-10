package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;


/**
 * Created by OPER on 10.04.2017.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 8, 10, 25, 35, 50, 100};
        int searchValue = 2;
        System.out.println(Arrays.toString(a));

        System.out.println("Element " + searchValue + " has index " + binarySearch(a, searchValue));


    }

    private static int binarySearch(int[] a, int value) {
        int resultIndex = -1;
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int index = l + (r - l) / 2;
            if (a[index] > value) {
                r = index - 1;
                continue;
            } else if (a[index] < value) {
                l = index + 1;
                continue;
            } else if (a[index] == value) {
                resultIndex = index;
                break;
            }
        }
        return resultIndex;
    }
}