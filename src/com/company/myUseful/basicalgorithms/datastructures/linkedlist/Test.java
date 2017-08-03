package company.myUseful.basicalgorithms.datastructures.linkedlist;

/**
 * Created by user on 10.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        /*SLinkedList list = new SLinkedList(1, 2, 3); */

        SLinkedList list = SLinkedList.generateRandomList(20, 10);
        System.out.println(list.toString());

        list.removeIf(n -> n.value % 2 != 0);
        System.out.println(list.toString());
    }
}
