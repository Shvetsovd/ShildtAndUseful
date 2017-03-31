package company.myUseful.lambda;

import java.util.function.*;

import static java.lang.Math.*;
interface Runnable{
    void run();
}
class SomeClass {
    private Double value;

    public SomeClass() {
        value = 0.0;
    }

    public SomeClass(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    SomeClass sum(SomeClass a, SomeClass b) {
        return new SomeClass(a.value + b.value);
    }

    SomeClass sumWith(SomeClass other) {
        return new SomeClass(value + other.value);
    }
}

public class Test {


    static <T, R> R opBiFuncAdapter(BiFunction<T, T, R> f, T arg1, T arg2) {
        return f.apply(arg1, arg2);
    }

    static <R> R classFactory0Param(Supplier<R> cons) {
        return cons.get();
    }

    static <T, R> R classFactory1Param(Function<T, R> cons, T param) {
        return cons.apply(param);
    }


    static Double min(Double a, Double b) {
        return a < b ? a : b;
    }

    static Double max(Double a, Double b) {
        return a > b ? a : b;
    }


    public static void main(String[] args) {
        Supplier<Double>
                pi = () -> 3.14;
        System.out.println("PI = " + pi.get());

        Function<Double, Double>
                pow2 = x -> x * x;
        System.out.println("Pow2 test: 25^2 = " + pow2.apply(25.0));

        Function<Double, Double>
                sqrt2 = x -> Math.sqrt(x);
        System.out.println("sqrt test: sqrt(25) = " + sqrt2.apply(25.0));

        BiFunction<Double, Double, Double> hypo = (a, b) -> {
            if ((a <= 0.0) || (b <= 0.0)) {
                throw new IllegalArgumentException("length of sides must be positive");
            }
            return sqrt2.apply(pow2.apply(a) + pow2.apply(b));
        };
        Double result;

        //1
        result = hypo.apply(3.0, 4.0);
        System.out.println("Hypo test: a = 3 b = 4, hypo = " + result);

        //2
        result = opBiFuncAdapter(hypo, 3.0, 4.0);
        System.out.println("Hypo test2: a = 3 b = 4, hypo = " + result);

        //3
        result = opBiFuncAdapter(
                (a, b) -> sqrt(pow(a, 2) + pow(b, 2)),
                3.0, 4.0);
        System.out.println("Hypo test3: a = 3 b = 4, hypo = " + result);

        System.out.println("---\nRef to static methods");
        //4
        result = opBiFuncAdapter(Test::min, 10.0, 3.0);
        System.out.println("min test: a = 10 b = 3, min = " + result);

        //5
        result = opBiFuncAdapter(Test::max, 10.0, 3.0);
        System.out.println("max test : a = 10 b = 3, max = " + result);

        System.out.println("---\nRef to non-static methods");
        //6
        SomeClass objsc = new SomeClass();
        SomeClass objsc1 = new SomeClass(5.0);
        SomeClass objsc2 = new SomeClass(10.0);
        SomeClass resObj;

        resObj = opBiFuncAdapter(objsc::sum, objsc1, objsc2);
        resObj = opBiFuncAdapter((a, b) -> objsc.sum(a, b), objsc1, objsc2);

        resObj = opBiFuncAdapter(SomeClass::sumWith, objsc1, objsc2);
        resObj = opBiFuncAdapter((a, b) -> a.sumWith(b), objsc1, objsc2);

        //7
        SomeClass obj = new SomeClass();

        SomeClass ob1 = classFactory0Param(SomeClass::new);
        SomeClass obj2 = classFactory1Param(SomeClass::new, 10.0);

        String obj4 = classFactory0Param(String::new);
        String obj5 = classFactory1Param(String::new, "123");


    }


}
