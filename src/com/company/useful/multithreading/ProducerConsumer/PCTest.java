package company.useful.multithreading.ProducerConsumer;

import static java.lang.Thread.sleep;

/**
 * Created by user on 06.04.2017.
 */
class Q {
    int value;
    boolean isfree;

    public Q() {
        super();
        this.value = 0;
        isfree = true;
    }

    public synchronized int getValue() {
        while (isfree) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isfree = true;
        notifyAll();
        return this.value;
    }

    public synchronized void setValue(int value) {
        while (!isfree) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isfree = false;
        notifyAll();
    }
}

class Consumer {
    final Q targetQ;
    final int id;

    public Consumer(Q targetQ, int id) {
        super();
        this.targetQ = targetQ;
        this.id = id;
        new Thread(() -> {
            while (true) {
                System.out.println("Consumer" + this.id + ": <-- " + targetQ.getValue() + "\n");
                try {
                    sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Producer {
    final Q targetQ;
    final int id;

    public Producer(Q targetQ, int id) {
        super();
        this.targetQ = targetQ;
        this.id = id;
        new Thread(() -> {
            while (true){

                int newValue = (int)(Math.random() * 100);
                targetQ.setValue(newValue);
                System.out.println("Producer" + this.id + ": --> " + newValue);
                try {
                    sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

public class PCTest{
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q, 1);
        new Producer(q, 2);
        new Consumer(q, 1);
        new Consumer(q, 2);
        new Consumer(q, 3);
        new Consumer(q, 5);
    }
}