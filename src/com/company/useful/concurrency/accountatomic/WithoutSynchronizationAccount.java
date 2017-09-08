package company.useful.concurrency.accountatomic;

public class WithoutSynchronizationAccount extends Account {
    {
        synchType = "Without synchronization";
    }

    @Override
    void addCash(long qnty) {
        cash++;
    }

    @Override
    void takeCash(long qnty) {
        cash--;
    }
}
