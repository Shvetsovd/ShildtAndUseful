package company.useful.concurrency.accountatomic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new WithoutSynchronizationAccount());
        accounts.add(new SynchronizedAccount());
        accounts.add(new AtomicAccount());
        accounts.add(new LockAccount());

        for (Account account : accounts) {
            Account.test(account,10_000_000);
        }
    }
}
