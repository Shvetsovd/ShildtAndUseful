package company.shildt.chapter10;

/**
 * Created by dmitry on 10.02.17.
 */
public class Exc0 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int a = 42 / d;
            System.out.println("Это не будет выведено");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
        System.out.println("После оператора catch");
    }

    private static void subroutine() {

    }
}
