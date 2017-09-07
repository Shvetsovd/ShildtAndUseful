package company.useful.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class Account {
    private long cash;

   synchronized void addMoney(long qnty) {
        cash += qnty;
    }

    synchronized void getMoney(long qnty) {
        cash -= qnty;
    }

    public long getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return Long.toString(cash);
    }
}

public class AccountTest {
    static Account account = new Account();
    static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        System.out.println("Account before operations: " + account);

        threads.add(new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                account.addMoney(1);
            }
            latch.countDown();
        }));
        threads.add(new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                account.getMoney(1);
            }
            latch.countDown();
        }));
        for (Thread t : threads) {
            t.start();
        }

        latch.await();

        System.out.println("Account after operations: " + account);
    }
}
