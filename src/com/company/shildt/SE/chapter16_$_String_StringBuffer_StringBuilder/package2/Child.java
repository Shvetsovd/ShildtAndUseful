package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder.package2;

import company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder.package1.Super;

public class Child extends Super {
    public static void main(String[] args) {
        Child c = new Child();
        c.m();
    }
    void m() {
        this.a = 5; //ok
        super.a = 6; //ok, the same variable a
        System.out.println(this.a + " " + super.a);

        Child c = new Child();
        c.a = 5; //ok

        Super s = new Super();
        //s.a = 10; //compile-error
    }
}