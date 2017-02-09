package company.shildt.chapter8;

import java.lang.*;
import java.lang.Override;

/**
 * Created by OPER on 06.02.2017.
 */
public class AbstractDemo {
    public static void main(String[] args) {
        B b = new B();
        b.callme();
        b.callmetoo();
    }

}
abstract class A{
    abstract void callme();
    void callmetoo(){
        System.out.println("Это конкретный метод.");
    }
}
class B extends A{

    @Override
    void callme() {
        System.out.println("Реализация метода callme() из класса В.");
    }
}

