package company.shildt.chapter14;

import company.shildt.chapter10.ChainExcDemo;

/**
 * Created by OPER on 24.03.2017.
 */
interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MyClass(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T min() {
        T v = vals[0];
        for (T val : vals) {
            if (val.compareTo(v) < 0) {
                v = val;
            }
        }
        return v;
    }

    @Override
    public T max() {
        T v = vals[0];
        for (T val : vals) {
            if (val.compareTo(v) > 0) {
                v = val;
            }
        }
        return v;
    }
}

public class GenIFDemo {
    public static void main(String[] args) {
        MyClass<Integer> iob = new MyClass<>(new Integer[]{3, 6, 2, 8, 6});
        MyClass<Character> cob = new MyClass<>(new Character[]{'b','r','p','w'});

        System.out.println("Максимальное значение в массиве inums: " + iob.max());
        System.out.println("Минимальное значение в массиве inums: " + iob.min());

        System.out.println("Максимальное значение в массиве cob: " + cob.max());
        System.out.println("Минимальное значение в массиве cob: " + cob.min());
    }
}
