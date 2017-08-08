package company.eckel.collections.mycollection;

//: holding/CollectionSequence.java
import java.util.*;

public class CollectionSequence
        extends AbstractCollection<Integer> {
    private Integer[] arr = new Integer[10];
    public int size() { return arr.length; }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            public boolean hasNext() {
                return index < arr.length;
            }
            public Integer next() { return arr[index++]; }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
    }
}

