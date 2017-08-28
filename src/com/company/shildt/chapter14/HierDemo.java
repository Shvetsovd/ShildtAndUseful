package company.shildt.chapter14;


/**
 * Created by OPER on 24.03.2017.
 */
class Gen2<T, V> extends Gen<T> {
    V ob2;

    Gen2(T t, V v) {
        super(t);
        ob2 = v;
    }

    public V getOb2() {
        return ob2;
    }
}
public class HierDemo {
    public static void main(String[] args) {
        Gen2<String, Integer> x = new Gen2<>("Значение равно: ", 99);
        System.out.print(x.getob());
        System.out.print(x.getOb2());
    }
}
