package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class NonGen {
    private Object ob;

    NonGen(Object ob) {
        this.ob = ob;
    }

    Object getob() {
        return ob;
    }

    void showType() {
        System.out.println("Объект ob относится к типу: " +
                ob.getClass().getName());
    }
}

public class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;

        iOb = new NonGen(88);
        iOb.showType();
        int v = (Integer) iOb.getob();
        System.out.println("Значение: " + v);
        System.out.println();

        NonGen strOb = new NonGen("Тест без обобщений");
        strOb.showType();
        String str = (String) strOb.getob();
        System.out.println("Значение: " + str);

        iOb = strOb;
        ///v = (Integer) iOb.getob(); // RuntimeException - ClassCastException
    }
}
