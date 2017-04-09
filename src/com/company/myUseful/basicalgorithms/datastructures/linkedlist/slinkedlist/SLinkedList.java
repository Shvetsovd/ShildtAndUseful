package company.myUseful.basicalgorithms.datastructures.linkedlist.slinkedlist;

import java.util.Random;

/**
 * Created by user on 10.04.2017.
 */
public class SLinkedList {
    private Node tail;

    public SLinkedList(int... values) {
        super();

        if (values.length > 0) {
            this.tail = new Node(values[0], null);

            for (int i = 1; i < values.length; i++) {
                _addToEnd(values[i], this.tail);
            }
        }
    }

    private Node _addToEnd(int value, Node tail) {
        return (tail.next == null) ? tail.next = new Node(value, null) : _addToEnd(value, tail.next);
    }

    public String toString() {
        return _toString(tail);
    }

    private String _toString(Node tail) {
        return (tail == null) ? "*" : tail.value + " -> " + _toString(tail.next);
    }

    public static SLinkedList generateRandomList(int size, int maxValue) {
        Random r = new Random();
        int[] values = new int[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = r.nextInt(maxValue);
        }
        return new SLinkedList(values);
    }

    public static SLinkedList generateRandomList(int size) {
        return generateRandomList(size, Integer.MAX_VALUE);
    }

    private class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            super();
            this.value = value;
            this.next = next;
        }
    }
}

