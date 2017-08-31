//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package company.eckel.annotations;

import company.eckel.annotations.atunit.Test;
import company.eckel.net.mindview.util.OSExecute;


public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return
                testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        String classPath = "C:\\!BCP\\DMITRY\\!EBook\\MyStudyProjects\\IdeaProjects\\ShildtAndUseful\\out\\production\\ShildtAndUseful";
        OSExecute.command(
                "java " + "-classpath " +
                        classPath + " company.eckel.annotations.atunit.AtUnit " +
                        classPath + "\\company\\eckel\\annotations\\AtUnitComposition");
    }
} /* Output:
annotations.AtUnitComposition
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
