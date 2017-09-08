package company.useful.concurrency.accountatomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAccount extends Account {
    {
        synchType = "Lock";
    }

    private Lock lock = new ReentrantLock();

    @Override
    void addCash(long qnty) {
        lock.lock();
        try {
            cash++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    void takeCash(long qnty) {
        lock.lock();
        try {
            cash--;
        } finally {
            lock.unlock();
        }
    }
}
