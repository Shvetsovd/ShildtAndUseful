package company.myUseful.basicalgorithms.datastructures.linkedlist.slinkedlist;

/**
 * Created by user on 10.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        /*SLinkedList list = new SLinkedList(1, 2, 3);
        System.out.println(list.toString());*/

        SLinkedList list = SLinkedList.generateRandomList(15, 100);
        System.out.println(list.toString());
    }
}
