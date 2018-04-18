package company.ocpjp2.$3_Generics_and_Collections;

import java.util.*;

/**
 * Created by user on 29.03.2018.
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> list;
        Queue<String> queue;
        Set<String> set;

        list = new ArrayList<>(Arrays.asList("Mike", "Ann", "Mike", "Piter"));
        System.out.println(list); //[Mike, Ann, Mike, Piter]

        queue = new ArrayDeque<>(list);
        System.out.println(list); //[Mike, Ann, Mike, Piter]

        set = new HashSet<>(queue);
        System.out.println(set); //[Ann, Piter, Mike]

        set = new TreeSet<>(set);
        System.out.println(set); //[Ann, Mike, Piter]

        Map<String, Integer> map = new HashMap<>();
        map.put("Mike", 25);
        map.put("Ann", 18);
        map.put("Mike", 30);
        map.put("Piter", 22);
        System.out.println(map); //{Ann=18, Piter=22, Mike=30}

        map = new TreeMap<>(map);
        System.out.println(map); //{Ann=18, Mike=30, Piter=22}
    }
}
