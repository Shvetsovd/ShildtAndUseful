package company.shildt.chapter12.autoboxing;

/**
 * Created by dmitry on 24.02.17.
 */
public class UnboxingError {
    public static void main(String[] args) {

        Integer iOb = 1000;
        int i = iOb.byteValue();
        System.out.println(i);
    }
}
