package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class UseStatic {
    static int a = 3;
    static int b;

    static {
        System.out.println("Статический блок инициализирован.");
        b = a * 4;
    }

    static void meth(int x){
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void main(String[] args) {
        meth(42);
    }
}
