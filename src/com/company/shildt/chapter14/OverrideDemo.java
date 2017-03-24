package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class GenOD<T> {
    T ob;
    GenOD(T o){
        ob = o;
    }

    public T getOb() {
        System.out.print("Метод getOb() из класса Gen:");
        return ob;
    }
}

class GenOD2<T> extends GenOD<T>{
    GenOD2(T o){
        super(o);
    }

    @Override
    public T getOb(){
        System.out.print("Метод getOb() из класса Gen2:");
        return ob;
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        GenOD<Integer> iOb = new GenOD<>(88);
        GenOD2<Integer> iOb2 = new GenOD2<>(99);

        GenOD2<String> strOb2 = new GenOD2<>("Тест обобщений");

        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());
    }
}
