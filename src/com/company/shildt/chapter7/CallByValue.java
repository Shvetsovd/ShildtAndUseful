package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */

class Test2 {
    int a, b;

    public Test2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void  meth(Test2 o){
        o.a *= 2;
        o.b /= 2;
    }
}
public class CallByValue {
    public static void main(String[] args) {
        Test2 ob = new Test2(15, 20);

        System.out.println("a и b до вызова: " +
                            ob.a + " " + ob.b);

        ob.meth(ob);

        System.out.println("a и b после вызова: " +
                            ob.a + " " + ob.b);
    }
}
