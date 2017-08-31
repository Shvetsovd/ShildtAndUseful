package company.useful;

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
        //     Outer a = new Outer();
    /*will compile successfully, no instance of Test is needed to instantiate B */
        StaticTest.B b = new StaticTest.B();
        StaticTest a = new StaticTest();
        //Error - a.Outer aa = new StaticTest.Outer();


             /*Integer a = 300000000;
            Integer b = 300000000;

            System.out.println(b.equals(a));*/
    }
}
