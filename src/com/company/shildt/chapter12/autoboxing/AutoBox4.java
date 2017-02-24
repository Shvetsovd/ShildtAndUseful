package company.shildt.chapter12.autoboxing;

/**
 * Created by dmitry on 24.02.17.
 */
public class AutoBox4 {
    public static void main(String[] args) {
        Integer iOb = 100;
        Double dOb = 98.6;

        dOb += iOb;
        System.out.println("dOb после выражения: " + dOb);
    }
}
