//: annotations/StackLStringTest.java
// Applying @Unit to generics.
package company.eckel.annotations;

import company.eckel.annotations.atunit.Test;
import company.eckel.net.mindview.util.OSExecute;

public class StackLStringTest extends StackL<String> {
    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        push("B");
        assert top().equals("B");
        assert top().equals("B");
    }

    public static void main(String[] args) throws Exception {
        String classPath = "C:\\!BCP\\DMITRY\\!EBook\\MyStudyProjects\\IdeaProjects\\ShildtAndUseful\\out\\production\\ShildtAndUseful";
        OSExecute.command(
                "java " + "-classpath " +
                        classPath + " company.eckel.annotations.atunit.AtUnit " +
                        classPath + "\\company\\eckel\\annotations\\StackLStringTest");
    }
} /* Output:
annotations.StackLStringTest
  . _push
  . _pop
  . _top
OK (3 tests)
*///:~
