package company.ocpjp2.$3_Generics_and_Collections;


import java.util.*;

/**
 * Created by user on 29.03.2018.
 */
public class CollectionNullTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list); //[null, null, null]

        list = new LinkedList<>(list);
        System.out.println(list); //[null, null, null]

        Queue<Integer> queue = new LinkedList<>(list);
        System.out.println(queue); //[null, null, null]
        System.out.println(queue.element()); //null

        Set<Integer> set = new HashSet<>(queue);
        System.out.println(set); //[null]

        //queue = new ArrayDeque<>(queue); //NullPointerException
        //set = new TreeSet<>(list); //NullPointerException

        Map<String, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        System.out.println(map); //{null=null}

        //map = new TreeMap<>(map); //NullPointerException
    }
}
