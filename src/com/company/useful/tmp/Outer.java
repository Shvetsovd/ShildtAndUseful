package company.useful.tmp;

/**
 * Created by OPER on 04.04.2017.
 */

public class Outer {
    int value;
    //Inner inner = new Inner();
    static class Inner{
        int value1;
    }
}
class OuterTest{
    public static void main(String[] args) {
        Outer q = new Outer();
        //Outer.Inner inner = q.inner;

        //inner.value = 10;
        //Outer.Inner inner2 = new Outer.Inner(); //Compile error - Outer.Inner is non-static class

        //for static Inner class
        Outer.Inner inner = new Outer.Inner();
        int v = inner.value1;
    }
}
