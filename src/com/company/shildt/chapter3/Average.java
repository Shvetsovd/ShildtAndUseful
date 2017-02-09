package company.shildt.chapter3;

/**
 * Created by user on 09.01.2017.
 */

public class Average {
    public static void main(String[] args) {
        double nums[] = {10.1, 11.2, 12.3, 13.4, 14.5};
        double result = 0.0;
        int i;

        for(i = 0; i < 5; i++) result += nums[i];

        System.out.println("Среднее значение равно " + String.format("%.3f", result / 5));
    }
}
