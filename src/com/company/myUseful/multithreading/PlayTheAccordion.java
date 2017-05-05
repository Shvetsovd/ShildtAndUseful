package company.myUseful.multithreading;

/**
 * Created by OPER on 28.04.2017.
 */
public class PlayTheAccordion {
    public static void main(String[] args) throws InterruptedException {
        new PlayManager(3);
    }
}

class PlayManager implements Runnable {
    Thread[] threads;
    int countOfReplays;

    public PlayManager(int countOfReplays) throws InterruptedException {
        this.countOfReplays = countOfReplays;
        new Thread(this).start();
    }


    @Override
    public void run() {
        threads = new Thread[3];
        for (int i = 0; i < countOfReplays; i++) {
            threads[0] = new Thread(new Printer("Outer   .", 10, 100));
            threads[1] = new Thread(new Printer(".   B", 10, 99));
            threads[2] = new Thread(new Printer("  C  ", 10, 100));

            try {
                threads[0].start();
                threads[1].start();
                threads[0].join();
                threads[1].join();

                threads[2].start();
                threads[2].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Printer implements Runnable {
    String msg;
    int countOfPrint;
    int delay;

    public Printer(String msg, int countOfPrint, int delay) {
        this.msg = msg;
        this.countOfPrint = countOfPrint;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < countOfPrint; i++) {
            System.out.println(msg);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
