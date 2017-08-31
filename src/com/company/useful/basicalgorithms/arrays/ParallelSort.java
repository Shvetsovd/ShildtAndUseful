package company.useful.basicalgorithms.arrays;

import java.util.Random;

import static company.useful.basicalgorithms.arrays.QuickSort.quickSort;


public class ParallelSort {

    public static void main(String[] args) throws InterruptedException {
        long start;
        long stop;
        int[] a = new int[(int) 1E7];
        int[] b = new int[(int) 1E7];

        arrayRandomFill(a, 100);
        arrayRandomFill(b, 100);

        start = System.currentTimeMillis();

        quickSort(a);
        quickSort(b);

        stop = System.currentTimeMillis();

        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        System.out.println(stop - start + "ms");


        arrayRandomFill(a, 100);
        arrayRandomFill(b, 100);

        start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> quickSort(a), "Thread1");
        Thread t2 = new Thread(() -> quickSort(b), "Thread2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        stop = System.currentTimeMillis();


        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        System.out.println(stop - start + "ms");
    }

    public static void arrayRandomFill(int[] a, int maxValue) {
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(maxValue);
        }
    }
}
