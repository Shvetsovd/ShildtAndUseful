package company.shildt.chapter15;

import company.javaNotes.Interface;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyBiFunction<T> {
    int apply(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }
        return count;
    }
}

public class GenericMethodRefDemo {
    static <T> int myOp(MyBiFunction<T> function, T[] vals, T v) {
        return function.apply(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 4, 5};
        String[] strs = {"один", "два", "три", "два"};
        int count;

        count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("Массив vals содержит " + count + " числа 4");

        count = myOp(MyArrayOps::<String>countMatching, strs, "два");
        System.out.println("Массив str содержит " + count + " числа два");
    }
}
