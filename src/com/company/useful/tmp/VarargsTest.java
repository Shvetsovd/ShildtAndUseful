package company.useful.tmp;

/**
 * Created by OPER on 04.04.2017.
 */
public class VarargsTest {
    static void method() {
        System.out.println("method()");
    }

    static void method(int a) {
        System.out.println("method(int a)");
    }
    static void method(int... v) {
        System.out.println("method(int...v)");
    }

    static void method(int a, int... v) {
        System.out.println("method(int a)");
    }

    static void method(boolean... v) {
        System.out.println("method(boolean...v)");
    }

    public static void main(String[] args) {
        method(); //ok - call method()
        method(1); //ok - call method(int a)
        //method(1, 2); //error - method(int...v) || method(int a,int...v)?
    }
}
