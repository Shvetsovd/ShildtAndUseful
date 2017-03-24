package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class Gen<T>{
    private T ob;

    public Gen(T o) {
        this.ob = o;
    }

    public T getob() {
        return ob;
    }
    void showType(){
        System.out.println("Типом Т является " + ob.getClass().getName());
    }

}
public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);
        iOb.showType();

        int v = iOb.getob();
        System.out.println("Значение: " + v);
        System.out.println();

        Gen<String> strOb = new Gen<>("Тест обобщений");
        strOb.showType();
        String str = strOb.getob();
        System.out.println("Значение: " + str);
    }
}
