package company.ocpjp2.$3_Generics_and_Collections;

import java.util.Map;

/**
 * Created by user on 24.03.2018.
 */
public class MapTest {
    public static void main(String[] args) {
        //--- From Map interface ---
        //void clear()
        //boolean isEmpty()
        //int size()
        //void forEach(Consumer action)

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
        //E lower(E e)
        //E floor(E e)
        //E higher(E e)
        //E ceiling(E e)

        hashMapTest();
        treeMapTest();

    }

    private static void hashMapTest() {
    }

    private static void treeMapTest() {
    }
}
