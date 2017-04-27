package company.myUseful.basicalgorithms.recurse;

import java.util.function.UnaryOperator;

/**
 * Created by user on 10.04.2017.
 */
public class Factorial {
    public static void main(String[] args) {

        UnaryOperator<Integer> fact = n -> {
            int f = 1;
            for (int i = 1; i <= n; i++) {
                f *= i;
            }
            return f;
        };
        UnaryOperator<Integer> fact2 = Factorial::fact;

        System.out.println(fact(5));
        System.out.println(fact.apply(5));
        System.out.println(fact2.apply(5));
    }

    private static int fact(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be positive");
        return (n == 1) ? 1 : n * fact(n - 1);
    }
}
