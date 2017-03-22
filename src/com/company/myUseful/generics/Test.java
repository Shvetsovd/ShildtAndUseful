package company.myUseful.generics;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by OPER on 16.03.2017.
 */
public class Test {
    public static void main(String[] args) {

        Object objs[] = new Object[10];
        Integer intgs[] = new Integer[10];

        objs = intgs;

        objs[0] = 10;
        //objs[1] = "123"; //runtime error (ArrayStoreException)
        Integer intg = (Integer) objs[0];
        //String s = (String) objs[0]; //runtime error (ClassCastExceprion)


        List list = new ArrayList<>();
        List<Number> listNumber = new ArrayList<Number>();
        List<Integer> listInteger = new ArrayList<Integer>();
        List<Double> listDouble = new ArrayList<Double>();

        //listNumber = listInteger; //compile error

        listNumber.add(new Integer(10));
        listNumber.add(new Double(3.14));
        Number num = listNumber.get(0);

        Integer i = (Integer) listNumber.get(0);
        //Integer j = listNumber.get(0);  //- compile err
        //Double d = listNumber.get(1);   // - compile err
        //String str = listNumber.get(0); // - compile err

    }
}

class Test2<T> {
    private T t;

    public T method(T t) {
        return t;
    }
}

class Test3 extends Test2<Object> {
    public static void main(String[] args) {

        Method[] methods = Test3.class.getMethods();

        for (Method m : methods){
            System.out.println(m.getReturnType().getName() + " " + m.getName() + "()");
        }
    }

    @Override
    public String method(Object o) {
        return "123";
    }

}


class Test4 {
    public static void main(String[] args) {
/*        Object obj = new Object();
        Integer intg = new Integer(10);

        obj = intg;
        obj = 0.5F;
        System.out.println(obj.getClass().getName());
        System.out.println(obj);*/

        //---

        Object[] objarr = new Object[10];


        objarr[0] = 0.5F;
        objarr[1] = "str";

        System.out.println(Arrays.toString(objarr));

        printArrayClasses(objarr);

        Integer[] intarr = new Integer[10];
        objarr = intarr;
        objarr[0] = 1;
        objarr[1] = "str";
        //Integer i = "str";
        printArrayClasses(objarr);

        //---

/*
        List rawList = new ArrayList();
        List<Number> intgList = new ArrayList<>();

        intgList.add(1);
        //intgList.add(new Object());
        //intgList.add("str");

        rawList = intgList;
        rawList.add("str");
        printCollectionClasses(rawList);
*/


    }

    private static <T> void printCollectionClasses(Collection<T> collection) {
        System.out.println(collection.toString());
        System.out.print("[");
        for (T elem : collection) {
            System.out.print(elem.getClass().getName() + ",");
        }
        System.out.println("]");
    }

    private static <T> void printArrayClasses(T[] objarr) {
        System.out.print("[");
        for (T o : objarr) {
            if (o == null) {
                System.out.print("null,");
            } else {
                String className = o.getClass().getName();
                System.out.print(className.substring(className.lastIndexOf('.') + 1) + ",");
            }
        }
        System.out.print("]");
    }
}

