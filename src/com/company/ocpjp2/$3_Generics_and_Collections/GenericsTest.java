package company.ocpjp2.$3_Generics_and_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 29.03.2018.
 */
public class GenericsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<? super String> objList = list;
        Object o = objList.get(1);
        list.add("N");

        System.out.println(objList);
    }
}

class Pack<T> {
    private T contents;

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public <V> void open(V header) {
        System.out.println(header + ":" + contents);
    }

}


