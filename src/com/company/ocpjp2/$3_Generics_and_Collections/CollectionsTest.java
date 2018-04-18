package company.ocpjp2.$3_Generics_and_Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 29.03.2018.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,7,5,3);

        Collections.sort(list);
        System.out.println(list); //[3, 5, 7, 9]

        System.out.println(Collections.binarySearch(list, 3)); // 0
        System.out.println(Collections.binarySearch(list, 2)); // -1
    }
}
