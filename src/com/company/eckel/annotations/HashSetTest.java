//: annotations/HashSetTest.java
package company.eckel.annotations;

import java.util.*;

import company.eckel.annotations.atunit.Test;
import company.eckel.net.mindview.util.OSExecute;

public class HashSetTest {
    HashSet<String> testObject = new HashSet<String>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void _remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        String classPath = "C:\\!BCP\\DMITRY\\!EBook\\MyStudyProjects\\IdeaProjects\\ShildtAndUseful\\out\\production\\ShildtAndUseful";
        OSExecute.command(
                "java " + "-classpath " +
                        classPath + " company.eckel.annotations.atunit.AtUnit " +
                        classPath + "\\company\\eckel\\annotations\\HashSetTest");
    }
} /* Output:
annotations.HashSetTest
  . initialization
  . _remove
  . _contains
OK (3 tests)
*///:~
