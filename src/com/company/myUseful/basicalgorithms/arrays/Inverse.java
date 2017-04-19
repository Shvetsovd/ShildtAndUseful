package company.myUseful.basicalgorithms.arrays;

import java.util.Arrays;

/**
 * Created by user on 10.04.2017.
 */
public class Inverse {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(inverse(a)));

        inverseRecursive(a, 0);
        System.out.println(Arrays.toString(a));
    }

    private static void inverseRecursive(int[] a, int i) {
        if (i == a.length / 2) return;
        inverseRecursive(a, i + 1);
        swap(a, i, a.length - 1 - i);
    }

    private static int[] inverse(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            swap(a, left++, right--);
        }
        return a;
    }

    private static int[] inverse2(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - 1 - i);
        }
        return a;
    }

    private static int[] inverse3(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            swap(a, i, a.length - 1 - i);

        }
        return a;
    }

    private static void swap(int[] a, int left, int right) {
       /* int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;*/

/*        a[left] = a[left] + a[right];
        a[right] = a[left] - a[right];
        a[left] = a[left] - a[right];*/

        a[left] ^= a[right];
        a[right] ^= a[left];
        a[left] ^= a[right];
    }
}
