package company.myUseful.generics;

import company.shildt.chapter3.Array;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

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

    public T getT() {
        return t;
    }

    public T method() {
        return t;
    }
}

class Test3 extends Test2 {
    @Override
    public String method() {
        return "123";
    }
}


