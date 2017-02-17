package company.shildt.chapter11;

/**
 * Created by dmitry on 17.02.17.
 */
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дочерний поток создан: " + t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0 ; i--) {
            System.out.println("Дочерний поток: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Дочерний поток прерван");
            }

        }
        System.out.println("Дочерний поток завершен");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();

        for (int i = 5; i > 0 ; i--) {
            System.out.println("Главный поток: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван");
            }

        }
        System.out.println("Главный поток завершен");
    }
}
