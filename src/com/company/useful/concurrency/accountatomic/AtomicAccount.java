package company.useful.concurrency.accountatomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount extends Account {
    {
        synchType = "Atomic";
    }

    AtomicLong value = new AtomicLong(cash);

    @Override
    void addCash(long qnty) {
        cash = value.incrementAndGet();
    }

    @Override
    void takeCash(long qnty) {
        cash = value.decrementAndGet();
    }
}
