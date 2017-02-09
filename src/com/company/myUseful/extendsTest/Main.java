package company.myUseful.extendsTest;

/**
 * Created by OPER on 25.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        A ab = new B();
        //B bb = new A(); // error

        System.out.println(a instanceof B);
        System.out.println(b instanceof A);
        System.out.println(ab instanceof A);
        System.out.println(ab instanceof B);

    }

}
