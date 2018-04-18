package company.ocpjp2.$3_Generics_and_Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 24.03.2018.
 */
public class MapTest {
    public static void main(String[] args) {
        //--- From Map interface ---
        //void clear()
        //boolean isEmpty()
        //int size()
        //void forEach(BiConsumer action)

        //V put(K key, V value)
        //V get(Object key)
        //V remove(Object key)
        //boolean containsKey(Object key)
        //boolean containsValue(Object)
        //Set<K> keySet()
        //Collection<V> values()

        //V putIfAbsent(K key, V value)
        //V merge(K key, V value, BiFunction remappingValue)


        //--- From NavigableMap interface (for TreeMap only!) ---
        //Entry<K, V> ceilingEntry(K k)
        //K ceilingKey(K k)

        mapTest();
    }
    private static void mapTest() {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.isEmpty()); //true
        System.out.println(map.put("Mike", 25)); //null
        System.out.println(map.put("Mike", 35)); //25
        System.out.println(map.size()); //1
        System.out.println(map.put("John", 18)); //null
        System.out.println(map.put("Kate", 22)); //null
        System.out.println(map.put("Peter", 50)); //null
        System.out.println(map.containsKey(new Object())); //false
        System.out.println(map.containsKey(22)); //false
        System.out.println(map.containsValue(22)); //true
        System.out.println(map.containsKey("Kate")); //true
        System.out.println(map.remove("22")); //null
        System.out.println(map.remove("Kate")); //22
        System.out.println(map); //{Mike=35, John=18, Peter=50}
        System.out.println(map.putIfAbsent("Peter", 3)); //50
        System.out.println(map.putIfAbsent("Peter1", 3)); //null
        System.out.println(map.remove("Peter1")); //3
        System.out.println(map); //{Mike=35, John=18, Peter=50}
        System.out.println(map.merge("Zed", 12, (v1, v2) -> v1 + v2)); //12
        System.out.println(map); //{Mike=35, Zed=12, John=18, Peter=50}
        System.out.println(map.merge("Zed", 28, (v1, v2) -> v1 + v2)); //40
        System.out.println(map); //{Mike=35, Zed=40, John=18, Peter=50}

        map = new TreeMap<>(map);
        System.out.println(map); //{John=18, Mike=35, Peter=50, Zed=40}

        Map<String, Integer> map1 = new TreeMap<>((k1, k2) -> k2.compareTo(k1));
        map1.putAll(map); //void
        System.out.println(map1); //{Zed=40, Peter=50, Mike=35, John=18}
        map1.forEach((k, v) -> System.out.println(k + " - " + v));
        //Zed - 40
        //Peter - 50
        //Mike - 35
        //John - 18

        Map<MapTest, Integer> hMap = new HashMap<>();
        hMap.put(new MapTest(), 10); //null
        hMap.put(new MapTest(), 5); //null
        hMap.put(new MapTest(), 4); //null
        System.out.println(hMap); //{MapTest@2503dbd3=5, MapTest@4b67cf4d=4, MapTest@330bedb4=10}

        for (Map.Entry<MapTest, Integer> entry : hMap.entrySet()) {
            System.out.println(entry.getKey() + " :: " + entry.getValue());
            //MapTest@2503dbd3 :: 5
            //MapTest@4b67cf4d :: 4
            //MapTest@330bedb4 :: 10
        }

        for (MapTest k : hMap.keySet()) {
            System.out.println(k + " :: " + hMap.get(k));
            //MapTest@2503dbd3 :: 5
            //MapTest@4b67cf4d :: 4
            //MapTest@330bedb4 :: 10
        }

        for (Integer value : hMap.values()) {
            System.out.println(value);
            //5
            //4
            //10
        }
        //Map<MapTest, Integer> tMap = new TreeMap<>(hMap); //ClassCastException: cannot be cast to Comparable
    }
}
