package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class LinkedList {
    private static class Node{
        int value;
        Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node tail;
    private int size;

    public boolean add(int value){
        tail = addRecursive(tail, value);
        size++;
        return true;
    }
    private Node addRecursive(Node node, int value){
        if (node == null){
            return new Node(value, null);
        }
        node.next = addRecursive(node.next, value);
        return node;
    }

    public boolean add(int index, int value){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == size){
            return add(value);
        }
        tail = addRecursive(tail, index, value);
        size++;
        return true;
    }

    private Node addRecursive(Node node, int index, int value) {
        if (index == 0){
            return new Node(value, node);
        }
        node.next = addRecursive(node.next, index - 1, value);
        return node;
    }

    public boolean removeLast(){
        if (size == 0){
            throw new IndexOutOfBoundsException();
        }
        removeLastRecursive(tail);
        size--;
        return true;
    }

    private Node removeLastRecursive(Node tail) {
        if (tail.next == null){
            return null;
        }
        tail.next = removeLastRecursive(tail.next);
        return tail;
    }

    public boolean removeFirst(){
        if (size == 0){
            return false;
        }
        tail = tail.next;
        size--;
        return true;
    }

    public boolean remove(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == size - 1){
            return removeLast();
        }
        removeRecursive(tail, index);
        size--;
        return true;
    }

    private Node removeRecursive(Node tail, int index) {
        if (index == 0){
            return tail.next;
        }
        tail.next = removeRecursive(tail.next, index - 1);
        return tail;
    }

    public void inverse(){
        tail = inverseRecursive(tail, null, tail);
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

    @Override
    public String toString() {
        return toStringRecursive(tail, "");
    }

    private String toStringRecursive(Node node, String s) {
        if (node == null){
            return s += "*";
        }
        s += node.value + "->";
        return toStringRecursive(node.next, s);
    }
    public int size(){
        return size;
    }
}
