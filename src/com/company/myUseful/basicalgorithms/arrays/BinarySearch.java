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

    private static int binarySearch(int[] a, int searchValue) {
        int resultIndex = -1;
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int midIndex = l + (r - l) / 2;
            int midValue = a[midIndex];

            if (searchValue < midValue) {
                r = midIndex - 1;

            } else if (searchValue > midValue) {
                l = midIndex + 1;
            } else {
                resultIndex = midIndex;
                break;
            }
        }

        return resultIndex;
    }

}