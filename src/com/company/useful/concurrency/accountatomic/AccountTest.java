package company.useful.concurrency.accountatomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

abstract class Account {
    protected volatile long cash;
    protected String synchType;

    abstract void addCash(long qnty);

    abstract void takeCash(long qnty);

    @Override
    public String toString() {
        return Long.toString(cash);
    }

    public static void test(Account account, long iterationCount) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        CountDownLatch endLatch = new CountDownLatch(2);

        System.out.printf("%s--->\n", account.synchType);
        System.out.println("Account before operations: " + account);

        long start = System.nanoTime();

        pool.submit(new Thread(() -> {
            for (int i = 0; i < iterationCount; i++) {
                account.addCash(1);
            }
            endLatch.countDown();
        }));
        pool.submit(new Thread(() -> {
            for (int i = 0; i < iterationCount; i++) {
                account.takeCash(1);
            }
            endLatch.countDown();
        }));

        try {
            endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long stop = System.nanoTime();

        System.out.println("Account after operations: " + account);
        System.out.printf("Time: %d ms\n", TimeUnit.MILLISECONDS.convert((stop - start), TimeUnit.NANOSECONDS));
        System.out.println("---");

        pool.shutdown();

    }
}

