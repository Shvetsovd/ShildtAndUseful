package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class ArraysUtilities {
    public static int sum(int[] a) {
        return getSumRecursive(a, 0);
    }

    private static int getSumRecursive(int[] a, int index) {
        if (index == a.length) {
            return 0;
        }
        return a[index] + getSumRecursive(a, index + 1);
    }

    public static int getMaxValue(int[] a){
        return getMaxValueRecursive(a, 0);
    }

    private static int getMaxValueRecursive(int[] a, int index) {
        if (index == a.length - 1){
            return a[index];
        }
        return Math.max(a[index], getMaxValueRecursive(a, index + 1));
    }

    public static void main(String[] args) {
        int[] a = {1, 20, 15, 3};
        System.out.println(getMaxValue(a));
    }
}
