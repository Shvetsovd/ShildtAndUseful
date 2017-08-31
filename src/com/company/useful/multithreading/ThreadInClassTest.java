package company.useful.multithreading;

/**
 * Created by user on 21.02.2017.
 */

class ThreadInClass {
    Thread thread;
    String msg;

    public ThreadInClass(String msg) {
        this.msg = msg;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                meth();
            }
        });
        thread.start();
        thread.destroy();
    }

    void meth() {
        System.out.println(msg);
    }
}

public class ThreadInClassTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadInClass obj = new ThreadInClass("Выполняется в новом потоке");
    }
}
