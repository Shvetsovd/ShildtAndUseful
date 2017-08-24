package company.eckel.containers;//: containers/Groundhog2.java
// A class that's used as a key in a HashMap
// must override hashCode() and equals().

import java.util.Objects;

public class Groundhog2 extends Groundhog {
    String s;

    public Groundhog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        if(o == this) return true;

        return o instanceof Groundhog2
                && Objects.equals(s, ((Groundhog2) o).s)
                && (number == ((Groundhog2) o).number);

    }
} ///:~
