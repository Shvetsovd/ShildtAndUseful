package company.ocpjp2.$3_Generics_and_Collections;

import java.util.*;

/**
 * Created by user on 24.03.2018.
 */
public class ListTest {
    public static void main(String[] args) {
        //--- From Collection interface ---
        //boolean add(E element)
        //boolean remove(Object o)
        //boolean contains(Object o)

        //void clear()
        //boolean isEmpty()
        //int size()

        //void forEach(Consumer action)
        //boolean removeIf(Predicate p)


        //--- From List interface ---
        //void add(int index, E element)
        //E set(int index, E e)
        //E get(int index)
        //E remove(int index)

        //int indexOf(Object o)
        //int lastIndexOf(Object o)
        //void replaceAll(UnaryOperator o)

        //Object[] toArray();
        //T[] toArray(T[] a);


        //Implementations - ArrayList, LinkedList
        listTest();
    }

    private static void listTest() {
        //Collection
        Collection<Integer> collection = new ArrayList<>();

        System.out.println(collection.add(15)); //true
        System.out.println(collection.add(25)); //true
        System.out.println(collection.add(18)); //true
        System.out.println(collection); //[15, 25, 18]

        System.out.println(collection.contains(25)); //true
        System.out.println(collection.remove(25)); //true
        System.out.println(collection.contains(25)); //false
        System.out.println(collection.remove("abc")); //false
        System.out.println(collection); //[15, 18]

        System.out.println(collection.size()); //2
        System.out.println(collection.isEmpty()); //false
        //System.out.println(collection.clear()); //Doesn't compile - void
        collection.clear();
        System.out.println(collection.isEmpty()); //true

        System.out.println(collection.addAll(Arrays.asList(15, 25, 18))); //true
        collection.forEach(System.out::println);
        //15
        //25
        //18
        System.out.println();

        //List
        List<Integer> list = (List<Integer>) collection;
        System.out.println(list.remove(0)); //15
        //System.out.println(list.remove(25)); //IndexOutOfBoundsException
        //System.out.println(list.add(2, 88)); //Doesn't compile - void
        list.add(2, 88);
        list.add(2, 98);
        System.out.println(list); //[25, 18, 98, 88]
        System.out.println(list.get(0)); //25
        System.out.println(list.set(0, 3)); //25
        System.out.println(list.indexOf(3)); //0
        System.out.println(list.lastIndexOf(3)); //0
        System.out.println(list.indexOf(30)); //-1
        System.out.println(list.lastIndexOf(30)); //-1
        List<Integer> linkList = new LinkedList<>(list);
        System.out.println(linkList); //[3, 18, 98, 88]
        System.out.println(linkList.remove(3)); //88
        System.out.println(linkList.remove("abc")); //false
        System.out.println(linkList); //[3, 18, 98]
        System.out.println(linkList.remove(new Integer(3))); //true
        list.replaceAll((x) -> x * x); //void
        System.out.println(linkList); //[324, 9604]
    }
}
