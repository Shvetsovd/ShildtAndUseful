package company.my.interview.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * Created by user on 28.03.2018.
 */

public class ListPerfomanceTest {
    //<Params>
    private static List<Integer> list = new ArrayList<>();
    private static final int ITERATIONS = 100_000;
    //</Params>

    private static Map<String, Long> stats;
    private static Random r;
    private long testTime;

    @FunctionalInterface
    private interface Operation {
        void perform();
    }

    @BeforeClass
    public static void init() {
        stats = new TreeMap<>();
        r = new Random();
    }

    @Before
    public void reset() {
        if (list instanceof ArrayList<?>) {
            list = new ArrayList<>();
        } else if (list instanceof LinkedList<?>) {
            list = new LinkedList<>();
        }
        testTime = 0;
    }

    @Test
    public void findByObject(){
        randomFill();
        testTime = run(()->{
           boolean b = list.contains(r.nextInt());
        });
        addToStats("Find (object)", testTime);
    }
    @Test
    public void headWriteTest() {
        testTime = run(() -> list.add(0, r.nextInt()));
        addToStats("Head(write)", testTime);
    }

    @Test
    public void headReadTest() {
        randomFill();
        testTime = run(() -> {
            Integer i = list.remove(0);
        });
        addToStats("Head(read)", testTime);
    }

    @Test
    public void tailWriteTest() {
        testTime = run(() -> {
            boolean b = list.add(r.nextInt());
        });
        addToStats("Tail(write)", testTime);
    }

    @Test
    public void tailReadTest() {
        randomFill();
        testTime = run(() -> {
            Integer i = list.remove(list.size() - 1);
        });
        addToStats("Tail(read)", testTime);
    }

    @Test
    public void RandomAccessWriteTest() {
        testTime = run(() -> {
            int index = list.size() == 0 ? 0 : r.nextInt(list.size());
            list.add(index, r.nextInt());
        });
        addToStats("Random(write)", testTime);
    }

    @Test
    public void RandomAccessReadTest() {
        randomFill();
        testTime = run(() -> {
            int index = list.size() == 0 ? 0 : r.nextInt(list.size());
            Integer i = list.remove(index);
        });
        addToStats("Random(read)", testTime);
    }

    private long run(Operation operation) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            operation.perform();
        }
        long finish = System.currentTimeMillis();

        return finish - start;
    }

    private void randomFill() {
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(r.nextInt());
        }
    }

    private void addToStats(String caption, Long value) {
        stats.put(caption, value);
    }

    @AfterClass
    public static void printStatistics() {
        System.out.println("<<<" + list.getClass().getSimpleName() + ">>>");
        System.out.println("Iterations = " + ITERATIONS);
        System.out.println();
        System.out.printf("%-15s: %s\n", "Operation", "Time(sec)");
        System.out.printf("%-15s: %s\n", "-", "-");
        for (Map.Entry<String, Long> entry : stats.entrySet()) {
            System.out.printf("%-15s: %.3f\n", entry.getKey(), entry.getValue() / 1000.0);
        }
    }


}

/*
<<<ArrayList>>>
Iterations = 100000

Operation      : Time(sec)
-              : -
Find (object)  : 12,150
Head(read)     : 1,434
Head(write)    : 1,452
Random(read)   : 0,709
Random(write)  : 0,661
Tail(read)     : 0,004
Tail(write)    : 0,005


<<<LinkedList>>>
Iterations = 100000

Operation      : Time(sec)
-              : -
Find (object)  : 74,876
Head(read)     : 0,005
Head(write)    : 0,012
Random(read)   : 6,184
Random(write)  : 15,452
Tail(read)     : 0,002
Tail(write)    : 0,006

----------------------

<<<ArrayList>>>
Iterations = 300000

Operation      : Time(sec)
-              : -
Find (object)  : 152,892
Head(read)     : 12,904
Head(write)    : 12,650
Random(read)   : 6,080
Random(write)  : 5,867
Tail(read)     : 0,003
Tail(write)    : 0,009

<<<LinkedList>>>
Iterations = 300000

Operation      : Time(sec)
-              : -
Find (object)  : 679,193
Head(read)     : 0,007
Head(write)    : 0,017
Random(read)   : 86,855
Random(write)  : 282,453
Tail(read)     : 0,005
Tail(write)    : 0,080

*/