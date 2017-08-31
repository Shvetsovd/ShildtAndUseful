package company.useful.basicalgorithms.recurse;

import java.util.concurrent.RecursiveTask;

/**
 * Created by user on 10.04.2017.
 */
public class Fibbonachi {
    public static void main(String[] args) {
        long start, stop;
        start = System.currentTimeMillis();
        System.out.print(fib(30));
        //1 1 2 3 5 8
        stop = System.currentTimeMillis();
        System.out.println("\t" + (stop - start) + "ms");


        start = System.currentTimeMillis();
        System.out.print(new Fibonacci(30).compute());

        stop = System.currentTimeMillis();
        System.out.println("\t" + (stop - start) + "ms");
    }

    private static int fib(int n) {
        if (n < 0) throw new IllegalArgumentException("number of member must be positive");
        return (n <= 1) ? n : fib(n - 2) + fib(n - 1);
    }
}

class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1)
            return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }
}
