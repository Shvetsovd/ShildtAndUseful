package company.my.interview_test;

public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(A::m);
        Thread t2 = new Thread(B::m);
        t1.start();
        t2.start();
    }
}

class A {
    public static synchronized void m() {
        try {
            B.m();
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class B {
    public static synchronized void m() {
        try {
            A.m();
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
