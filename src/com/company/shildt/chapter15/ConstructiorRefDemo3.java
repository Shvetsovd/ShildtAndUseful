package company.shildt.chapter15;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyFunc4<R, T> {
    R func(T n);
}

class MyClassGen<T> {
    private T val;

    MyClassGen() {
        val = null;
    }

    MyClassGen(T v) {
        val = v;
    }

    T getVal() {
        return val;
    }

}

class MyClassNonGen {
    private String str;

    MyClassNonGen() {
        str = "";
    }

    MyClassNonGen(String str) {
        this.str = str;
    }

    String getStr() {
        return str;
    }
}

public class ConstructiorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc4<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc4<MyClassGen<Double>, Double> myClassGenCons = MyClassGen<Double>::new;
        MyClassGen<Double> mc = myClassFactory(myClassGenCons, 100.1);

        System.out.println("Значение val в объекте mc равно: " + mc.getVal());

        MyFunc4<MyClassNonGen, String> myClassNonGenCons = MyClassNonGen::new;
        MyClassNonGen mc2 = myClassFactory(myClassNonGenCons, "Лямбда");

        System.out.println("Значение str в объекте mc2 равно: " + mc2.getStr());

        MyFunc4<MyClassNonGen[], Integer> myClassNonGenArrayCons = MyClassNonGen[]::new;
        MyClassNonGen[] mcArray = myClassFactory(myClassNonGenArrayCons, 2);
        mcArray[0] = myClassFactory(myClassNonGenCons, "Лямбда");
        mcArray[1] = myClassFactory(myClassNonGenCons, "выражение");

        System.out.println("Значние a[0]: " + mcArray[0].getStr());
        System.out.println("Значние a[1]: " + mcArray[1].getStr());
    }
}
