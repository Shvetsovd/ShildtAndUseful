package company.eckel.generics.mygenericTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Product{}
class Camera extends Product{}
class Phone extends Product{}

public class MyGenericTest2 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        System.out.println(list);

        Camera camera1 = new Camera();
        Camera camera2 = new Camera();
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        MyGenericTest2.add(list,
                camera1,
                camera2,
                phone1,
                phone2,
                phone3);

        System.out.println(list);
        System.out.println(MyGenericTest2.contain(list, phone2));

    }
    static boolean contain(List<? extends Product> list, Product product){
        return list.contains(product);
    }
    static void add(List<? super Product> list, Product...products){
        list.addAll(Arrays.asList(products));
    }
}
