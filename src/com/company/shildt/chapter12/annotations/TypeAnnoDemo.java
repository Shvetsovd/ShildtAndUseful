package company.shildt.chapter12.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Objects;

/**
 * Created by dmitry on 25.02.17.
 */
@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

@Target(ElementType.TYPE_USE)
@interface Unique {
}

@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}

@Target(ElementType.TYPE_PARAMETER)
@interface WhatIs {
    String description();
}

@Target(ElementType.FIELD)
@interface EmptyOk {
}

@Target(ElementType.METHOD)
@interface Recommended {
}

class TypeAnnoDemo<@WhatIs(description = "Данные обощенного типа") T> {
    public @Unique TypeAnnoDemo() {
    }

    @TypeAnno String str;

    @EmptyOk
    String test;

    public int f(@TypeAnno TypeAnnoDemo<T>this, int x) {
        return 10;
    }

    public @TypeAnno Integer f2(int j, int k) {
        return j + k;
    }

    @Recommended
    public Integer f3(String str) {
        return str.length() / 2;
    }

    String w@MaxLen(10)[]@NotZeroLen[];

    @TypeAnno Integer[] vec;

    public static void myMeth(int i) {
        TypeAnnoDemo<@TypeAnno Integer> ob =
                new TypeAnnoDemo<@TypeAnno Integer>();

        @Unique TypeAnnoDemo<Integer> ob2 = new @Unique TypeAnnoDemo<Integer>();
        Object x = new Integer(10);
        Integer y;

        y = (@TypeAnno Integer) x;
    }

    public static void main(String[] args) {
        myMeth(10);
    }

    class SomeClass extends @TypeAnno TypeAnnoDemo<Boolean> {
    }

}

