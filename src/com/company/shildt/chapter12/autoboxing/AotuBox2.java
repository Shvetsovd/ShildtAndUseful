package company.shildt.chapter12.autoboxing;

/**
 * Created by dmitry on 24.02.17.
 */
public class AotuBox2 {
    static int m(Integer v){
        return v;
    }

    public static void main(String[] args) {
        Integer iOb = m(100);
        System.out.println(iOb);
    }
}
