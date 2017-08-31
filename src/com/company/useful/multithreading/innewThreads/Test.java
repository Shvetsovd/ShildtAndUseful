package company.useful.multithreading.innewThreads;

import com.sun.istack.internal.NotNull;

/**
 * Created by OPER on 06.04.2017.
 */
public class Test {
    public static void main(String[] args) {

        inNewThread(() -> System.out.println(Thread.currentThread().getName() + ": " + "Hello"));
    }

    private static Thread inNewThread(@NotNull Runnable code) {
        Thread t = new Thread(code);
        t.start();
        return t;
    }
}
