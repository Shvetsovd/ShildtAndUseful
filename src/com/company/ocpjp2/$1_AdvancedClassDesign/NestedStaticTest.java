package company.ocpjp2.$1_AdvancedClassDesign;

import java.awt.image.VolatileImage;

/**
 * Created by user on 09.03.2018.
 */

class Outer1{
    static class NestedStatic{}
}
class Outer2{
    private static int a = 0;
    private int b = 1;

    public static class NestedStatic{
        private static int c = 2;
        private int d = 3;

        private static void stM(){
            a++;
            new Outer2().b++;
            c++;
            new NestedStatic().d++;
        }
        private void m(){
            a++;
            new Outer2().b++;
            c++;
            d++;
        }

    }

    private static void stM(){
        a++;
        new Outer2().b++;
        NestedStatic.c++;
        new NestedStatic().d++;
    }
    private void m(){
        a++;
        b++;
        NestedStatic.c++;
        new NestedStatic().d++;
    }
}
public class NestedStaticTest {
    public static void main(String[] args) {
        Outer outerObj = new Outer();

        Outer2.NestedStatic nsObj1 = new Outer2.NestedStatic();
        //NestedStatic nsObj2 = new Outer.NestedStatic(); //  COMPILE ERROR
    }
}
