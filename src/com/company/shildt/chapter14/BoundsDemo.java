package company.shildt.chapter14;

import com.sun.org.glassfish.external.probe.provider.StatsProviderInfo;

/**
 * Created by OPER on 24.03.2017.
 */
class Stats<T extends Number> {
    private T[] nums;

    public Stats(T[] o) {
        nums = o;
    }

    public double average() {
        double sum = 0.0;

        for (T num : nums) {
            sum += num.doubleValue();
        }

        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
}

public class BoundsDemo {
    public static void main(String[] args) {
        //Integer inums[] = {1, 2, 3, 4, 5};
        //Stats<Integer> iob = new Stats<>(inums);

        Stats<Integer> iob = new Stats<>(new Integer[]{1, 2, 3, 4, 5});
        double v = iob.average();
        System.out.println("Среднее значение iob равно: " + v);

        Stats<Double> dob = new Stats<>(new Double[]{1.1, 2.2, 3.3, 4.4, 5.5});
        double w = dob.average();
        System.out.println("Среднее значение dob равно: " + w);

        //Compile Error - String is not extend Number

        /*String[] strs = {"1", "2","3","4","5"};
        Stats<String> strOb = new Stats<String>(strs);
        double x = strOb.average();
        System.out.println("Стреднее значение strOb равно: " + x);*/
    }
}
