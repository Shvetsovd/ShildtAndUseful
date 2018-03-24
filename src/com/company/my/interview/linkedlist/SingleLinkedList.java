package company.my.interview.linkedlist;

/**
 * Created by user on 23.03.2018.
 */
public class SingleLinkedList {
    private Node tail;

    private static class Node {
        private int value;
        private Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public SingleLinkedList() {
    }

    public boolean add(int value) {
        tail = addRecursive(tail, value);
        return true;
    }

    private Node addRecursive(Node tail, int value) {
        if (tail == null) {
            return new Node(value, null);
        }
        tail.next = addRecursive(tail.next, value);
        return tail;
    }

    @Override
    public String toString() {
        return toStringRecursive(tail, "");
    }

    private String toStringRecursive(Node tail, String s) {
        if (tail == null) {
            s += "*";
            return s;
        } else {
            s += tail.value;
            s += " -> ";
            return toStringRecursive(tail.next, s);
        }
    }
}

class Test{
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        System.out.println(list);
        list.add(15);
        list.add(12);
        list.add(35);
        list.add(7);
        System.out.println(list);
    }
}
