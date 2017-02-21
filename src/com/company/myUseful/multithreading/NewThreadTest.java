package company.myUseful.multithreading;

/**
 * Created by user on 21.02.2017.
 */

class NewThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Выполняется в новом потоке");
        }
    }
}

public class NewThreadTest {
    public static void main(String[] args) {
        NewThread thread = new NewThread();
        thread.start();
    }
}


