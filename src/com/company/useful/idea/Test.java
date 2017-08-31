package company.useful.idea;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        showThreadName(Thread.currentThread());
        System.out.println(Arrays.toString(values));

        new Thread(() -> {
            showThreadName(Thread.currentThread());
            System.out.println(average(values));

        }).start();

    }

    private static void showThreadName(Thread thread) {
        System.out.print(thread.getName() + ":\t\t");
    }

    private static double average(int[] values) {
        double sum = 0.0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];

        }
        sum = 0.0;
        for (int i = values.length - 1; i >= 0; i--) {
            sum += values[i];

        }
        sum = 0.0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}