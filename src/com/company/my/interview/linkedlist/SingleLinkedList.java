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

    public void inverse(){
        tail = inverseRecursive(tail, null, tail);
    }

    boolean isEquals(SingleLinkedList other){
        return isEqualRecursive(tail, other.tail);
    }

    private boolean isEqualRecursive(Node tailA, Node tailB) {
        if (tailA != null && tailB != null){
            return tailA.value == tailB.value && isEqualRecursive(tailA.next, tailB.next);
        } else {
            return tailA == tailB;
        }
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
            s = toStringRecursive(tail.next, s);
        }
        return s;
    }

    private Node addRecursive(Node tail, int value) {
        if (tail == null) {
            return new Node(value, null);
        }
        tail.next = addRecursive(tail.next, value);
        return tail;
    }

    private Node inverseRecursive(Node tail, Node left, Node right) {
        if (right == null){
            tail = left;
        } else {
            Node next = right.next;
            right.next = left;
            tail = inverseRecursive(tail, right, next);
        }
        return tail;
    }
}

class Test{
    public static void main(String[] args) {
        SingleLinkedList listA = new SingleLinkedList();
        listA.add(15);
        listA.add(12);
        listA.add(35);
        listA.add(7);

        System.out.println(listA);
    }
}
