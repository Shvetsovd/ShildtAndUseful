package company.myUseful.multithreading.deadlock;

import static java.lang.Thread.sleep;

/**
 * Created by OPER on 06.04.2017.
 */
class A {
    synchronized void foo(B b) throws InterruptedException {
        System.out.println("Outer.foo");
        sleep(1000);
        b.method();
    }

    synchronized void method() {
        System.out.println("Outer.method");
    }
}

class B {
    synchronized void bar(A a) throws InterruptedException {
        System.out.println("B.bar");
        sleep(1000);
        a.method();
    }

    synchronized void method() {
        System.out.println("B.method");
    }
}

public class DeadlockTest {
    A a;
    B b;
    Thread t1, t2;

    public DeadlockTest() throws InterruptedException {
        super();
        a = new A();
        b = new B();

        t1 = Thread.currentThread();
        t2 = new Thread(() -> {
            try {
                b.bar(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        a.foo(b);
    }

    public static void main(String[] args) throws InterruptedException {
        new DeadlockTest();
    }


}
