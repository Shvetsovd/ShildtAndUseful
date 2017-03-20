package company.myUseful.generics;

import company.shildt.chapter3.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OPER on 16.03.2017.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        ArrayList<Number> listNumber = new ArrayList<Number>();
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        ArrayList<Double> listDouble = new ArrayList<Double>();

        listNumber.add(new Integer(10));
        listNumber.add(new Double(3.14));
        Number num = listNumber.get(0);

        Integer i = (Integer) listNumber.get(0);
        //Integer j = listNumber.get(0);  //- err
        //Double d = listNumber.get(1);   // - err

    }
}
