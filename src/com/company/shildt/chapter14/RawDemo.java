package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */

public class RawDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        Gen<String> strOb = new Gen<>("Тест обобщений");

        Gen raw = new Gen(new Double(98.6));
        double d = (Double) raw.getob();
        System.out.println("Значение: " + d);

        //int i = (Integer) raw.getob(); //RuntimeException (ClassCastException)
        strOb = raw;
        //String str = strOb.getob(); //RuntimeException (ClassCastException)
        raw = iOb;
        //d = (Double) raw.getob(); //RuntimeException (ClassCastException)
    }
}
