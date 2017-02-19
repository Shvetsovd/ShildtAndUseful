package company.shildt.chapter11;

/**
 * Created by dmitry on 19.02.17.
 */
class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() throws InterruptedException {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Получено: " + n);
        valueSet = false;
        Thread.sleep(100);
        notify();
        return n;
    }

    synchronized void put(int n) throws InterruptedException {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено:" + n);
        Thread.sleep(100);
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            try {
                q.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                q.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        //System.out.println("Для выхода нажмите Ctrl-C");
    }
}
