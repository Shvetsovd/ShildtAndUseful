package company.myUseful.multithreading;

/**
 * Created by user on 21.02.2017.
 */
class Call {
    void meth(String msg) {
        System.out.println(msg);
    }
}

class Caller {
    Call callObj;
    Thread thread;
    String msg;

    public Caller(String msg) {
        this.msg = msg;
        thread = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                callObj = new Call();
                callObj.meth(msg);
            }
        });
        thread.start();
    }
}

public class ContainerThreadTest {
    public static void main(String[] args) {
        Caller caller = new Caller("выполняется в новом потоке");
    }
}
