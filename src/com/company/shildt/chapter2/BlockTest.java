package company.shildt.chapter2;

/**
 * Created by user on 29.12.2016.
 */

public class BlockTest {
    public static void main(String[] args) {
        int x, y;

        y = 20;

        for (x = 0; x < 10; x++){
            System.out.println("Значение x: " + x);
            System.out.println("Значение y: " + y);
            y -= 2;
        }
    }
}
