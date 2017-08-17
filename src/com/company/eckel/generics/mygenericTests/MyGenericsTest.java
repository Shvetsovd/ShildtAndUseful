package company.eckel.generics.mygenericTests;


import java.util.ArrayList;
import java.util.List;

public class MyGenericsTest {
    public static void main(String[] args) {
        Object obj;
        Number numb;
        Integer intg;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.get(0);

        obj = list.get(0);
        numb = list.get(0);
        intg = list.get(0);


        List<?> list1 = list;
        //list1.add(0);                     //Compile error
        //list1.add(new Object());          //Compile error
        list1.get(0);

        obj = list1.get(0);
        //numb = list1.get(0);              //Compile error
        //intg = list1.get(0);              //Compile error


        //List<Number> list2 = list;        //Compile error

        List<? extends Number> list3 = list;
        //list3.add(0);                     //Compile error
        //list3.add(new Object());          //Compile error
        list3.get(0);

        obj = list3.get(0);
        numb = list3.get(0);
        //intg = list3.get(0);              //Compile error


        //List<? super Number> list4 = list;  //Compile error

        List<? super Integer> list5 = list;
        list.add(0);
        //list.add(new Object());             //Compile error
        list.get(0);

        obj = list5.get(0);
        //numb = list5.get(0);               //Compile error
        //intg = list5.get(0);               //Compile error



    }
}
