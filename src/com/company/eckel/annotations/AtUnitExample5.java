//: annotations/AtUnitExample5.java
package company.eckel.annotations;

import company.eckel.annotations.atunit.Test;
import company.eckel.annotations.atunit.TestObjectCleanup;
import company.eckel.annotations.atunit.TestObjectCreate;
import company.eckel.annotations.atunit.TestProperty;
import company.eckel.net.mindview.util.OSExecute;

import java.io.*;

public class AtUnitExample5 {
    private String text;

    public AtUnitExample5(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }

    @TestProperty
    static PrintWriter output;
    @TestProperty
    static int counter;

    @TestObjectCreate
    static AtUnitExample5 create() {
        String id = Integer.toString(counter++);
        try {
            output = new PrintWriter("Test" + id + ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new AtUnitExample5(id);
    }

    @TestObjectCleanup
    static void
    cleanup(AtUnitExample5 tobj) {
        System.out.println("Running cleanup");
        output.close();
    }

    @Test
    boolean test1() {
        output.print("test1");
        return true;
    }

    @Test
    boolean test2() {
        output.print("test2");
        return true;
    }

    @Test
    boolean test3() {
        output.print("test3");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting");
        String classPath = "C:\\!BCP\\DMITRY\\!EBook\\MyStudyProjects\\IdeaProjects\\ShildtAndUseful\\out\\production\\ShildtAndUseful";
        OSExecute.command(
                "java " + "-classpath " +
                        classPath + " company.eckel.annotations.atunit.AtUnit " +
                        classPath + "\\company\\eckel\\annotations\\AtUnitExample5");
    }
} /* Output:
annotations.AtUnitExample5
  . test1
Running cleanup
  . test2
Running cleanup
  . test3
Running cleanup
OK (3 tests)
*///:~
