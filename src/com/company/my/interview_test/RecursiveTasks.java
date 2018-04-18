package company.my.interview_test;


import java.util.Arrays;

/**
 * Created by user on 14.04.2018.
 */
public class RecursiveTasks {
    public static int fact(int n){
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1){
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int fib(int n){
        if (n < 0 ){
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int getSumDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + getSumDigits(num / 10);
    }

    public static int getMaxDigit(int num) {
        if (num == 0) {
            return 0;
        }
        return Math.max(num % 10, getMaxDigit(num / 10));
    }

    public static void printArray(int[] a) {
        printArrayRecursive(a, a.length - 1);
    }

    private static void printArrayRecursive(int[] a, int index) {
        if (index == -1) {
            return;
        }
        printArrayRecursive(a, index - 1);
        System.out.println(a[index]);
    }

    public static void printInverseArray(int[] a) {
        printInverseArrayRecursive(a, 0);
    }

    private static void printInverseArrayRecursive(int[] a, int index) {
        if (index == a.length) {
            return;
        }
        printInverseArrayRecursive(a, index + 1);
        System.out.println(a[index]);
    }

    public static void permutations(int[] a) {
        permutationsRecursive(a, a.length);
    }

    private static void permutationsRecursive(int[] a, int length) {
        if (length == 1) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 0; i < length; i++) {
            swap(a, i, length - 1);
            permutationsRecursive(a, length - 1);
            swap(a, i, length - 1);
        }
    }


    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        printInverseArray(new int[]{1, 2, 3,});
    }
}

