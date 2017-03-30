package company.shildt.chapter15;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyFunc3<T> {
    MyClass3<T> func(T n);
}

class MyClass3<T> {
    private T val;

    public MyClass3() {
        val = null;
    }

    public MyClass3(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc3<Integer> myClassCons = MyClass3<Integer>::new;

        MyClass3<Integer> mc = myClassCons.func(100);

        System.out.println("Значение val в объекте mc равно: " + mc.getVal());
    }
}
