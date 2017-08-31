package company.useful.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by OPER on 04.04.2017.
 */
class SomeClassx {
    int a;
    public SomeClassx() {
        this(0);
    }
    public SomeClassx(int a) {
        this.a = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {

        return a;
    }

    @Override
    public boolean equals(Object obj) {
        SomeClassx other = (SomeClassx) obj;
        return this.a == other.a;
    }
}
public class RefToMethods {
    public static void main(String[] args) {
        SomeClassx sc1 = new SomeClassx(10);
        SomeClassx sc2 = new SomeClassx(10);
        //Predicate<SomeClassx> isEquals = SomeClassx::equals; //compile error

        Predicate<SomeClassx> scEquals = sc1::equals; //ok - sc1.equals(other)
        System.out.println("sc1 == sc2 is " + scEquals.test(sc2));

        BiPredicate<SomeClassx, SomeClassx> isEquals = SomeClassx::equals; //ok - ?.equals(other)
        System.out.println("sc1 == sc2 is " + isEquals.test(sc1,sc2)); // sc1.equals(sc2)



    }
}
