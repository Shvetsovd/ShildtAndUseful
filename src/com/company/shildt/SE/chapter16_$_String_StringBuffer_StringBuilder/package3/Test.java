package company.shildt.SE.chapter16_$_String_StringBuffer_StringBuilder.package3;

/**
 * Created by user on 11.05.2017.
 */
interface IA {
    /*default void f() {
        System.out.println("IA.f()");
    }*/
    void f();
}

interface IB {
    /*default void f() {
        System.out.println("IB.f()");
    }*/
    //void f();
}

interface IC extends IA, IB{

}


public class Test implements IA, IB {

    public static void main(String[] args) {
        //IB test = new Test();
        //test.f();
    }


    @Override
    public void f() {
        System.out.println("f()");
    }
}





