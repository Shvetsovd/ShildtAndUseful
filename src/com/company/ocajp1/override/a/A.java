package company.ocajp1.override.a;

import company.ocajp1.override.b.B;

/**
 * Created by user on 19.01.2018.
 */
public class A {
    private void mPrivate(){
        System.out.println("A.mPrivate");
    }
    void mDefault(){
        System.out.println("A.mDefault");
    }
    public void mPublic(){
        System.out.println("A.mPublic");
    }

}

class Test{
    public static void main(String[] args) {
        A a = new B();
        a.mDefault();
    }
}