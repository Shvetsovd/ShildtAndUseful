package company.eckel.generics.mygenericTests;

import java.util.ArrayList;
import java.util.List;

public class MyGenericTest3 {
    public static void main(String[] args) {

        //Raw list - heap pollution everywhere
        List rawList = new ArrayList();
        exactWithoutArgument(rawList);                              //ok
        exactWithArgument(rawList, 0);                        //ok

        extendsWildcardWithoutArgument(rawList);                    //ok
        extendsWildcardWithArgument(rawList, 0);              //ok
        extendsWildcardWithArgument(rawList, "abc");          //ok

        superWildcardWithoutArgument(rawList);                      //ok
        superWildcardWithArgument(rawList, 0);                //ok
        superWildcardWithArgument(rawList, "abc");            //ok
        //---

        //List<Integer>
        List<Integer> listIntg = new ArrayList<>();
        exactWithoutArgument(listIntg);                             //ok
        exactWithArgument(listIntg, 0);                       //ok
        //exactWithArgument(listIntg, 0L);                          //compile error

        extendsWildcardWithoutArgument(listIntg);                   //ok
        extendsWildcardWithArgument(listIntg, 0);             //ok
        extendsWildcardWithArgument(listIntg, 0L);            //ok - up T to Number type
        extendsWildcardWithArgument(listIntg, "abc");         //ok - up T to Object type

        superWildcardWithoutArgument(listIntg);                     //ok
        superWildcardWithArgument(listIntg, 0);               //ok
        //superWildcardWithArgument(listIntg, 0L);                  //compile error
        //superWildcardWithArgument(listIntg, new Object());        //compile error
        //---

        //List<?>
        List<?> listUnbound = new ArrayList<Integer>();
        exactWithoutArgument(listUnbound);                          //ok
        //exactWithArgument(listUnbound, 0);                        //compile error
        //exactWithArgument(listUnbound, "abc");                    //compile error

        extendsWildcardWithoutArgument(listUnbound);                //ok
        extendsWildcardWithArgument(listUnbound, 0);          //ok
        extendsWildcardWithArgument(listUnbound, new Object());     //ok

        //superWildcardWithoutArgument(listUnbound);                //compile error
        superWildcardWithoutArgument(new ArrayList<Object>());      //ok
        //superWildcardWithArgument(listUnbound, 0);                //compile error
        //superWildcardWithArgument(listUnbound, "abc");            //compile error

        /*Вывод:
        *
        * 1)при использовании сырых листов все присваивается в любые стороны
        * 2)при использовании точных типов проверяются точные соответствия
        * 3) при использовании extends происходит поиск и подстановка подходящего типа по иерархии (
        * т.е. достаточно вольно обращаемся с типами, т.к. extends открывает только чтение)
        * 4) при использовании super происходят самые строгие проверки типов и при малейших сомениях будет ошибка компиляции
        * (т.к. super дает право на запись)
        *
        * */


    }

    static <T> void exactWithoutArgument(List<T> list){

    }
    static <T> void exactWithArgument(List<T> list, T value){

    }
    static <T> void extendsWildcardWithoutArgument(List<? extends T> list){

    }
    static <T> void extendsWildcardWithArgument(List<? extends T> list, T value){

    }
    static <T> void superWildcardWithoutArgument(List<? super T> list){

    }
    static <T> void superWildcardWithArgument(List<? super T> list, T value){

    }

}
