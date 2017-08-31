//: annotations/Testable.java
package company.eckel.annotations;

import company.eckel.annotations.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~
