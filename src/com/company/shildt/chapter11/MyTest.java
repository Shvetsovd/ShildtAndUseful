package company.shildt.chapter11;

import java.util.Objects;

/**
 * Created by dmitry on 17.02.17.
 */
public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        int n = 100;

        Thread t[] = new Thread[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Thread(new Test(Integer.toString(i)));
            t[i].start();
        }

        for (Thread tInst : t){
            tInst.join();
        }

        for(Thread tInst : t){
            System.out.println(tInst.getName());
        }



        /*new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + ":\t" + 'A' + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread t = new Thread(new Test());
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();*/
    }
}

class Test implements Runnable {

    private String msg;

    Test(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println(Thread.currentThread() + ":\t" + 'B' + i);
            System.out.println(this.msg);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
