package company.useful.concurrency.accountatomic;

public class SynchronizedAccount extends Account {

    {
        synchType = "Synchronized";
    }

    @Override
    synchronized void addCash(long qnty) {
        cash++;
    }

    @Override
    synchronized void takeCash(long qnty) {
        cash--;
    }
}
