package company.shildt.chapter4;

/**
 * Created by user on 10.01.2017.
 */

public class Factorial {
    public static void main(String[] args) {
        int a = 5;

        System.out.println("Факториал числа " + a + " равен: " + fact(a));
    }

    public static int fact(int n){
        if (n == 1) return n;
        else
        return n * fact(n-1);
    }
}
