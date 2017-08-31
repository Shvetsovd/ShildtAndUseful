package company.useful.multithreading;

/**
 * Created by user on 21.02.2017.
 */
class Call {
    void meth(String msg) {
        System.out.println(msg);
    }
}

class Caller implements Runnable{
    Call target;
    Thread thread;
    String msg;

    public Caller(Call target, String msg) {
        this.target = target;
        this.msg = msg;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (target){
            target.meth(msg);
        }
    }
}

public class ContainerThreadTest {
    public static void main(String[] args) {
        Caller caller = new Caller(new Call(), "выполняется в новом потоке");
    }
}
