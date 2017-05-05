package company.myUseful.multithreading;

/**
 * Created by user on 02.05.2017.
 */
public class OverrideUncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Exception in thread: " + Thread.currentThread().getName() + ", " + e.getMessage());
                e.printStackTrace(System.err);
            }
        });
        throw new RuntimeException("bla-bla-bla");
    }
}
