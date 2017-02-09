package company.shildt.chapter8;

import java.lang.*;
import java.lang.Override;

/**
 * Created by OPER on 06.02.2017.
 */
public class Dispatch {
    static class A {
        void callMe() {
            System.out.println("В методе callme() из класса А");
        }
    }

    static class B extends A {
        @Override
        void callMe() {
            System.out.println("В методе callme() из класса В");
        }
    }

    static class C extends B {
        @Override
        void callMe() {
            System.out.println("В методе callme() из класса С");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        A r;
        r = a;
        r.callMe();

        r = b;
        r.callMe();

        r = c;
        r.callMe();

    }
}
