package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class StaticByName {
    public static void main(String[] args) {
        StaticDemo.callMe();
        System.out.println("b = " + StaticDemo.b);
    }
}
class StaticDemo{
    static int a;
    static int b;

    static {
        a = 42;
        b = 99;
    }
    static void callMe(){
        System.out.println("a = " + a);
    }

}
