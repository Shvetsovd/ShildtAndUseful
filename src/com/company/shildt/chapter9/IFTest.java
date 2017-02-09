package company.shildt.chapter9;

import static java.lang.Math.random;

/**
 * Created by dmitry on 07.02.17.
 */
public class IFTest {
    public static void main(String[] args) {
        FixedStack myStack1 = new FixedStack(5);
        FixedStack myStack2 = new FixedStack(8);

        for (int i = 0; i < 5; i++) {
            myStack1.push((int) (random() * 100));
        }
        for (int i = 0; i < 8; i++) {
            myStack2.push((int) (random() * 100));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(myStack1.pop());
        }

        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.println(myStack2.pop());
        }

    }
}
