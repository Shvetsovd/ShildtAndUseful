package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(10);
        list.add(7);
        list.add(2);
        list.add(20);
        list.add(15);
        System.out.println(list);
        list.inverse();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.add(3, 30);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
