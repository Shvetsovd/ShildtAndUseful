package company.eckel.polymorph;


class Parent {
    void m1() {
        System.out.println("Parent.m1()");
        m2();
    }

    void m2() {
        System.out.println("Parent.m2()");
    }
}

class Child extends Parent {
    @Override
    void m2() {
        System.out.println("Child.m2()");
    }
}

public class Example2 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.m1();
    }
}
