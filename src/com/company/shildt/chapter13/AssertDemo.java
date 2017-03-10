package company.shildt.chapter13;

/**
 * Created by dmitry on 10.03.17.
 */
public class AssertDemo {
    static int val = 3;

    static int getNum() {
        return val--;
    }

    public static synchronized void main(String[] args) {
        int n;
        for (int i = 0; i < 10; i++) {
            n = getNum();

            assert n > 0 : "n отрицательное!";

            System.out.println(n);
        }
    }
}
