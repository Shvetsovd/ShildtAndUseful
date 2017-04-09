package company.myUseful.basicalgorithms.math;

/**
 * Created by user on 10.04.2017.
 */
public class Fibbonachi {
    public static void main(String[] args) {
        System.out.println(fib(5));
        //1 1 2 3 5 8
    }

    private static int fib(int n) {
        if (n < 0) throw new IllegalArgumentException("number of member must be positive");
        return (n < 2) ? 1 : fib(n - 2) + fib(n - 1);
    }
}
