package company.eckel.arrays;

import java.util.Arrays;
import java.util.List;

public class AsList {
    public static void main(String[] args) {
        String[] strings = ("a b c").split(" ");
        List<String> list = Arrays.asList(strings);
        System.out.println(list);

        System.out.println("\n*Modify in List");
        list.set(0, "new element");
        System.out.println("Array: " + Arrays.toString(strings));
        System.out.println("List: " + list);

        System.out.println("\n*Modify in Array");
        strings[0] = "another string";
        System.out.println("Array: " + Arrays.toString(strings));
        System.out.println("List: " + list);

        //UnsupportedOperationExceprion
        //list.add(0, "something");

        //UnsupportedOperationExceprion
        //list.remove(0);
    }
}
