package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 05.03.2018.
 */
class A {
    private int x = 0;

    void m() {
        System.out.println("A.m");
        method();
    }

    void method() {
        System.out.println("A.method");
        System.out.println(x);
    }
}

class B extends A {
    private int x = 1;

    void method() {
        System.out.println("B.method");
        System.out.println(x);
    }
}

public class VMI {
    public static void main(String[] args) {
        A a = new B();
        a.m();
        /*
        Output:
        A.m
        B.method
        1
        */
    }
}
