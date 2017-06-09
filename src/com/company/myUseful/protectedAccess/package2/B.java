package company.myUseful.protectedAccess.package2;

import company.myUseful.protectedAccess.package1.A;

/**
 * Created by OPER on 08.06.2017.
 */
public class B extends A {
    void method(B b){
        b.x = 20;
    }
}

class C extends B{
    public static void main(String[] args) {
        Float f1 = 0.0f;
        Float f2 = 0.0f;
        System.out.println(f1 == f2);
    }
    static void meth(int a){
        System.out.println(a);
    }
}
