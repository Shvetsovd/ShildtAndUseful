//: net/mindview/atunit/TestProperty.java
// The @Unit @TestProperty tag.
package company.eckel.annotations.atunit;

import java.lang.annotation.*;

// Both fields and methods may be tagged as properties:
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestProperty {
} ///:~
