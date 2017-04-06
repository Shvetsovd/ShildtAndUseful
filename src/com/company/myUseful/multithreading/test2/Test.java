package company.myUseful.multithreading.test2;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;

/**
 * Created by OPER on 06.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        });
        t.setPriority(Thread.NORM_PRIORITY);


    }
}
