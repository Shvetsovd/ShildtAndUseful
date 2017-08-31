package company.useful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by OPER on 20.04.2017.
 */
public class MergeSort {
    public static void main(String[] args) {
        int a[] = {50, 30, 60, 20, 0, 100, 150, -100, 80};
        System.out.println(Arrays.toString(a));
        mergeSort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int start, int end) {
        int l = start;
        int r = end;
        if (r - l > 1) {
            int mid = start + (end - start) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid, r);

            int size = r - l;
            int[] mergedArray = new int[size];
            int firstIndex = l;
            int secondIndex = mid;

            for (int i = 0; i < size; i++) {
                if (a[firstIndex] < a[secondIndex]){
                    mergedArray[i] = a[firstIndex++];
                } else {
                    mergedArray[i] = a[secondIndex++];
                }
                if ((firstIndex == mid) && (secondIndex < r)){
                    System.arraycopy(a, secondIndex, mergedArray, i + 1, r - secondIndex);
                    break;
                }
                if ((secondIndex == r) && (firstIndex < mid)){
                    System.arraycopy(a, firstIndex, mergedArray, i + 1, mid - firstIndex);
                    break;
                }
            }
            System.arraycopy(mergedArray, 0, a, l, mergedArray.length);
        }
    }

}
