package company.useful.basicalgorithms.datastructures.linkedlist;

import java.util.Random;
import java.util.function.Predicate;

public class SLinkedList {
    private Node tail;
    private boolean isEmpty;

    public SLinkedList() {
        super();
        tail = null;
        isEmpty = true;
    }

    public SLinkedList(int... values) {
        super();

        if (values.length > 0) {
            this.tail = new Node(values[0], null);
            for (int i = 1; i < values.length; i++) {
                _addToEnd(values[i], this.tail);
            }
            isEmpty = false;
        }
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

    public void insert(int index, int value) {
        if (tail == null) {
            add(value);
        } else if (index == 0) {
            tail = new Node(value, tail);
        } else {
            _insert(tail, index, value);
        }
    }

    private void _insert(Node node, int index, int value) {
        if (node == null) throw new IllegalArgumentException("Invalid index");
        if (index == 1) {
            node.next = new Node(value, node.next);
        } else {
            _insert(node.next, --index, value);
        }
    }


    public void add(int value) {
        if (tail == null) {
            tail = new Node(value, null);
        } else {
            _addToEnd(value, tail);
        }
    }

    public void remove(int index) {
        if (tail == null) {
            throw new IllegalArgumentException("List is empty");
        } else if (index == 0) {
            tail = tail.next;
        } else {
            _remove(tail, index);
        }
    }

    private void _remove(Node node, int index) {
        if(node == null) throw new IllegalArgumentException("Invalid index");

        if (index == 1) {
            Node tmp = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            tmp.next = null;
        } else {
            _remove(node.next, --index);
        }
    }

    public void removeIf(Predicate<Node> condition) {
        if (tail == null) throw new IllegalArgumentException("List is empty");
        _removeIf(condition, tail, 0);
    }

    private void _removeIf(Predicate<Node> condition, Node node, int index) {
        if(node == null){
            return;
        }else {
            _removeIf(condition, node.next, index + 1);
        }
        if(condition.test(node)){
            remove(index);
        }
    }

    private Node _addToEnd(int value, Node tail) {
        /*if (tail.next == null) {
            tail.next = new Node(value, null);
        } else {
            _addToEnd(value, tail.next);
        }*/
        return (tail.next == null) ? tail.next = new Node(value, null) : _addToEnd(value, tail.next);

    }

    public String toString() {
        return _toString(tail);
    }

    private String _toString(Node tail) {
        return (tail == null) ? "*" : tail.value + " -> " + _toString(tail.next);
    }


    public class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            super();
            this.value = value;
            this.next = next;
        }
    }
}

