package company.shildt.chapter15;

/**
 * Created by OPER on 29.03.2017.
 */
interface NumericFunc<T> {
    T func(T n);
}

public class BlockLambdaDemo {
    public static void main(String[] args) {
        NumericFunc<Integer> factorial = n -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        NumericFunc<Integer> factorial2 = new NumericFunc<Integer>() {
            @Override
            public Integer func(Integer n) {
                int result = 1;
                for (int i = 1; i<=n; i++){
                    result *= i;
                }
                return result;
            }
        };

        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial2.func(5));
    }
}
