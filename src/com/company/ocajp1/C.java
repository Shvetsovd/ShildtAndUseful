package company.ocajp1;

import java.util.ArrayList;

/**
 * Created by user on 21.01.2018.
 */
public class C {
    public static void main(String[] args) {
        String s = "123";
        s += null;
        System.out.println(s);
    }
}

class IncrementTest {
    public static void main(String[] args) {
        int numTests = 10;

        long preTime = 0;
        long postTime = 0;
        int totalTests = 0;

        for (int i = 0; i < numTests; i++, totalTests++) {
            preTime += pre();
            postTime += post();
        }
        for (int i = 0; i < numTests; i++, totalTests++) {
            postTime += post();
            preTime += pre();
        }
        System.out.println("PreIncrement time = " + preTime / totalTests);
        System.out.println("PostIncrement time = " + postTime / totalTests);
    }

    private static long pre() {
        long y = 0;

        long start = System.currentTimeMillis();
        for (long i = 0; i < 5_000_000_000L; ++i);
        long stop = System.currentTimeMillis();

        return stop - start;
    }

    private static long post() {
        long y = 0;

        long start = System.currentTimeMillis();
        for (long i = 0; i < 5_000_000_000L; i++);
        long stop = System.currentTimeMillis();

        return stop - start;
    }
}
