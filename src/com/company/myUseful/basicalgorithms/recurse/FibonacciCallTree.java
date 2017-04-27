package company.myUseful.basicalgorithms.recurse;

/**
 * Created by OPER on 20.04.2017.
 */
public class FibonacciCallTree {
    public static void main(String[] args) {
        fib(5);
    }

    private static int fib(int arg) {
        System.out.print(" " + arg);
        return (arg <= 1) ? arg : fib(arg - 2) + fib(arg - 1);

    }
}
