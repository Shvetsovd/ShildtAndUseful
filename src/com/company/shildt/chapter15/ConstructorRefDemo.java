package company.shildt.chapter15;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyFunc2{
    MyClass2 func(int n);
}
class MyClass2{
    private int val;

    public MyClass2() {
        val = 0;
    }

    public MyClass2(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc2 myClassCons = MyClass2::new;

        MyClass2 mc = myClassCons.func(100);
        System.out.println("Значение val в объекте mc равно: " + mc.getVal());
    }

}
