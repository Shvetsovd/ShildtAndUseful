package company.myUseful;

/**
 * Created by dmitry on 24.01.17.
 */
class StaticTest {

        class A { }
        static class B { }
}

class Test{
    public static void main(String[] args) {
    /*will fail - compilation error, you need an instance of StaticTest to instantiate A*/
        //     A a = new A();
    /*will compile successfully, no instance of Test is needed to instantiate B */
        StaticTest.B b = new StaticTest.B();
        StaticTest a = new StaticTest();
        //Error - a.A aa = new StaticTest.A();


             /*Integer a = 300000000;
            Integer b = 300000000;

            System.out.println(b.equals(a));*/
    }
}
