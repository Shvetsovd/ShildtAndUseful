package company.useful.multithreading.tests;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by user on 05.04.2017.
 */
public class Test {

    public static void main(String[] args) {
        List<Thread> treads = new ArrayList<>();
        Thread mainThread = Thread.currentThread();

        treads.add(new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("\t\t\tT1: " + i);
                try {
                    sleep((int)Math.random()*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        treads.add(new Thread(() -> {
            for (int i = 0; i < 127; i++) {
                System.out.println("T2: " + i + ": " + (char) i);
                try {
                    sleep((int)Math.random()*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        for (Thread t : treads) {
            t.start();
        }
        for (Thread t : treads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

