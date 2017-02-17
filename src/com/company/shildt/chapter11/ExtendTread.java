package company.shildt.chapter11;

/**
 * Created by dmitry on 17.02.17.
 */
class NewThread2 extends Thread {
    public NewThread2() {
        super("Демонстрационный поток");
        System.out.println("Дочерний поток: " + this);
        start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
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

public class ExtendTread {
    public static void main(String[] args) {
        Thread t = new NewThread2();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 5; i > 0; i--) {
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
