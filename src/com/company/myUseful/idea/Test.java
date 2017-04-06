package company.myUseful.idea;


import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.stream.util.ThreadLocalBufferAllocator;

import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        showThreadName(Thread.currentThread());
        System.out.println(Arrays.toString(values));

        inNewThread(() -> System.out.println(average(values)));
    }

    private static Thread inNewThread(@NotNull Runnable code) {
        Thread t = new Thread(code);
        t.start();
        return t;
    }


    private static void showThreadName(Thread thread) {
        System.out.print(thread.getName() + ":\t\t");
    }

    private static double average(int[] values) {
        double sum = 0.0;

        for (int i = 0; i < values.length; i++) {
            sum += values[i];

        }


        return sum / values.length;
    }
}