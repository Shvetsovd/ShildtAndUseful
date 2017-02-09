package company.shildt.chapter9;

/**
 * Created by dmitry on 07.02.17.
 */

class Balance {
    String name;
    double bal;

    public Balance(String name, double bal) {
        this.name = name;
        this.bal = bal;
    }

    void show() {
        if (bal < 0) {
            System.out.print("-->");
        }
        System.out.println(name + ": $" + bal);
    }
}

public class AccountBalance {
    public static void main(String[] args) {
        Balance current[] = new Balance[3];

        current[0] = new Balance("K. J. Fielding", 123.23);
        current[1] = new Balance("Will Tell", 157.02);
        current[2] = new Balance("Tom Jackson", -12.33);

        for (Balance b : current){
            b.show();
        }
    }
}
