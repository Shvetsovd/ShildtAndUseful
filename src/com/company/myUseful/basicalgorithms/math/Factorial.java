package company.myUseful.basicalgorithms.math;

/**
 * Created by user on 10.04.2017.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    private static int fact(int n) {
        if (n < 1) throw new IllegalArgumentException("N must be positive");
        return (n == 1) ? 1 : n * fact(n - 1);
    }

}
