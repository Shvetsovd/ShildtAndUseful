package company.shildt.chapter13;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by dmitry on 10.03.17.
 */
public class Hypot {
    public static void main(String[] args) {
        double side1, side2;
        double hypot;

        side1 = 3.0;
        side2 = 4.0;

        hypot = sqrt(pow(side1, 2) + pow(side2, 2));

        System.out.println("a = " + side1 + " b = " + side2 + " hypot = " + hypot);

    }
}
