package company.eckel.generics.mygenericTests;


import java.util.ArrayList;
import java.util.List;

public class HeapPollution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List rawList = new ArrayList();

        //Heap pollution
        list = rawList; //Warning!

        rawList = list; //No warnings (чтобы не пугать методы унаследованного кода)
    }
}
