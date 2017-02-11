package company.shildt.chapter10;

/**
 * Created by dmitry on 12.02.17.
 */
public class ChainExcDemo {
    static void demoproc(){
        NullPointerException e = new NullPointerException("Верхний уровень");

        e.initCause(new ArithmeticException("причина"));

        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Перехавчено исключение: " + e);

            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
