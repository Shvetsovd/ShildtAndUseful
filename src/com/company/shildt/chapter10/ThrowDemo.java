package company.shildt.chapter10;

/**
 * Created by dmitry on 11.02.17.
 */
public class ThrowDemo {
    public static void main(String[] args) {

        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }

    private static void demoproc() {
        try {
            throw new NullPointerException("Демонстрация");
        } catch (NullPointerException e) {
            System.out.println(
                    "Исключение перехвачено в теле метода demoproc()"
            );
            throw e;
        }
    }
}
