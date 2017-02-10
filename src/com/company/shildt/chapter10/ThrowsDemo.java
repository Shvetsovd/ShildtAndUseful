package company.shildt.chapter10;

/**
 * Created by dmitry on 11.02.17.
 */
public class ThrowsDemo {
    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }

    private static void throwOne() throws IllegalAccessException {
        System.out.println("В теле метода throwsOne()");
        throw new IllegalAccessException("демонстрвция");
    }
}
