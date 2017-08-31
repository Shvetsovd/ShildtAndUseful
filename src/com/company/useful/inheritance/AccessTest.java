package company.useful.inheritance;

/**
 * Created by OPER on 25.04.2017.
 */
public class AccessTest {
    public static void main(String[] args) {
        A a = new B();
        a.fPub();
        //a.fPriv(); //compile error
    }
}

class A {
    public void fPub() {

    }

    private void fPriv() {

    }
}

class B extends A {

}