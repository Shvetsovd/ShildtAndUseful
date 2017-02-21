package company.myUseful.multithreading;

/**
 * Created by user on 21.02.2017.
 */

class NewRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Выполняется в новом потоке");
        }
    }
}
public class NewRunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnable());
        thread.start();
    }
}



