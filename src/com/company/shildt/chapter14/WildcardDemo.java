package company.shildt.chapter14;

import java.util.Iterator;

/**
 * Created by OPER on 24.03.2017.
 */

public class WildcardDemo {
    public static void main(String[] args) {
        Stats<Integer> iOb = new Stats<>(new Integer[]{1, 2, 3, 4, 5,});
        double i = iOb.average();
        System.out.println("Среднее значение iob равно: " + i);

        Stats<Double> dOb = new Stats<>(new Double[]{1.1, 2.2, 3.3, 4.4, 5.5});
        double d = dOb.average();
        System.out.println("Среднее значение dob равно: " + d);

        Stats<Float> fOb = new Stats<>(new Float[]{1.0F, 2.0F, 3.0F, 4.0F, 5.0F});
        double f = fOb.average();
        System.out.println("Среднее значение fob равно: " + f);

        System.out.print("Средние значения iob и dob ");
        if (iOb.sameAvg(dOb)) {
            System.out.println("равны. ");
        } else {
            System.out.println("отличаются");
        }

        System.out.println("Средние значения iob и fob ");
        if (iOb.sameAvg(fOb)){
            System.out.println("равны ");
        }else {
            System.out.println("отличаются ");
        }

    }

}
