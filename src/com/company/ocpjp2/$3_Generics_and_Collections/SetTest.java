package company.ocpjp2.$3_Generics_and_Collections;

import java.util.*;

/**
 * Created by user on 24.03.2018.
 */
public class SetTest {
    public static void main(String[] args) {
        //--- From Collection interface ---
        //boolean add(E element)
        //boolean remove(Object o)
        //boolean contains(Object o)

        //void clear()
        //boolean isEmpty()
        //int size()
        //void forEach(Consumer action)
        //boolean removeIf(Predicate filter)

        //--- From NavigableSet interface (for TreeSet only!) ---
        //E lower(E e)
        //E floor(E e)
        //E higher(E e)
        //E ceiling(E e)

        //Implementations - HashSet, TreeSet (+SortedSet, NavigableSet)

        hashSetTest();
        treeSetTest();

    }

    private static void hashSetTest() {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.add(5)); //true
        System.out.println(set.add(4)); //true
        System.out.println(set.add(5)); //false
        System.out.println(set.add(17)); //true
        System.out.println(set.add(10)); //true
        System.out.println(set.add(2)); //true
        System.out.println(set.add(null)); //ok
        System.out.println(set.remove(null)); //ok
        System.out.println(set); //[17, 2, 4, 5, 10]

        System.out.println(set.remove("abc")); //false
        System.out.println(set.contains("abc")); //false
        System.out.println(set.contains(null)); //false
        System.out.println(set.remove(null)); //false
        System.out.println(set.contains(10)); //true
        System.out.println(set.remove(10)); //true

        System.out.println(set.isEmpty()); //false
        System.out.println(set.size()); //4

        Set<Integer> tSet = new TreeSet<>(set);
        System.out.println(tSet); //[2, 4, 5, 17]

        set = new HashSet<>(Arrays.asList(12, 1, 9, 140, 12, 9, 17, 6));
        tSet = new TreeSet<>(Arrays.asList(12, 1, 9, 140, 12, 9, 17, 6));
        System.out.println(set); //[1, 17, 6, 9, 12, 140]
        System.out.println(tSet);//[1, 6, 9, 12, 17, 140]

        Object[] aSet = set.toArray(); //ok
        Integer[] integers = set.toArray(new Integer[0]); //ok
        //String[] strings = set.toArray(new String[0]); //ArrayStoreException: java.lang.Integer

    }


    private static void treeSetTest() {
        NavigableSet<Integer> nSet = new TreeSet<>(Arrays.asList(5, 12, 12, 12, 1, 8, 0));
        System.out.println(nSet); //[0, 1, 5, 8, 12]
        System.out.println(nSet.ceiling(8)); //8
        System.out.println(nSet.higher(8)); //12
        System.out.println(nSet.lower(8)); //5
        System.out.println(nSet.floor(8)); //8
        System.out.println(nSet.floor(-1)); //null

        nSet = new TreeSet<>((x1, x2) -> x2 - x1);
        nSet.addAll(Arrays.asList(5, 12, 12, 12, 1, 8, 0));
        System.out.println(nSet); //[12, 8, 5, 1, 0]
        //nSet.add(null); //NullPointerException

        Set<SetTest> set1 = new HashSet<>();
        set1.add(new SetTest());
        set1.add(new SetTest());
        set1.add(new SetTest());
        System.out.println(set1); //[SetTest@7699a589, SetTest@3b9a45b3, SetTest@7ba4f24f]

        Set<SetTest> set2 = new TreeSet<>(); //or TreeSet<SetTest> set2 = new TreeSet<>();
        //set2.add(new SetTest()); //ClassCastException: cannot be cast to Comparable
        System.out.println(set2);

    }
}
