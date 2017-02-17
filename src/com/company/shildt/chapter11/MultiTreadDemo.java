package company.shildt.chapter11;

/**
 * Created by dmitry on 17.02.17.
 */
class NewThread3 implements Runnable {
    String name;
    Thread t;

    public NewThread3(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " перерван");
            }
        }
        System.out.println(name + " завершен");
    }
}
public class MultiTreadDemo {
    public static void main(String[] args) {
        new NewThread3("Один");
        new NewThread3("Два");
        new NewThread3("Три");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
