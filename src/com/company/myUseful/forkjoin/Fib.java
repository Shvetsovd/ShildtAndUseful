package company.myUseful.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by OPER on 01.07.2017.
 */
public class Fib extends RecursiveTask<Integer> {
    Integer n;

    public Fib(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) return 1;

        Fib fib1 = new Fib(n - 1);
        fib1.fork();
        Fib fib2 = new Fib(n - 2);

        return fib1.compute() + fib2.join();
    }
}

class Test {
    public static void main(String[] args) {
        int n = 5;
        ForkJoinPool fjp = new ForkJoinPool();
        int result = fjp.invoke(new Fib(5));
        System.out.println(result);
    }
}
