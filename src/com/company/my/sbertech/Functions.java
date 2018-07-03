package company.my.sbertech;

/* Java */
public class Functions {
    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative Fib number: " + n);
        }
        return fibR(n);
    }

    private static int fibR(int n) {
        if (n <= 1) {
            return n;
        }
        return fibR(n - 1) + fibR(n - 2);
    }
}
