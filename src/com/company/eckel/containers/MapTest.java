package company.eckel.containers;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        System.out.println(map);
        map.put(1, "B");
        System.out.println(map);
        map.put(2, "B");
        System.out.println(map);
    }
}
