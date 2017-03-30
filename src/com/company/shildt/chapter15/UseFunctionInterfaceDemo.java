package company.shildt.chapter15;

import java.util.function.Function;

/**
 * Created by OPER on 30.03.2017.
 */
public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = n -> {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;

            }
            return fact;
        };

        System.out.println("Факториал числа 3 равен: " + factorial.apply(3));
        System.out.println("Факториал числа 5 равен: " + factorial.apply(5));
    }
}
