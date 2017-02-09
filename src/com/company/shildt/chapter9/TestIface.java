package company.shildt.chapter9;

/**
 * Created by dmitry on 07.02.17.
 */
public class TestIface {
    public static void main(String[] args) {
        Callback c = new Client();
        c.callback(42);
    }
}
