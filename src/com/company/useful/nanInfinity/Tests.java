package company.useful.nanInfinity;

/**
 * Created by user on 13.05.2017.
 */
public class Tests {
    public static void main(String[] args) {
        //Логическая операция != с NaN всегда дает true, любые другие оперции дают false
        //Любые арифметические операции с NaN всегда дают NaN
        double d = Double.NaN;
        System.out.println(d == Double.NaN); //false
        System.out.println(d != Double.NaN); //true
        System.out.println(5.0 != Double.NaN); //true
        System.out.println(Double.NaN == Double.NaN); //false

        d = Double.POSITIVE_INFINITY;
        //d *= 5; // = PositiveInfinity
        //d += Double.POSITIVE_INFINITY; // = PositiveInfinity
        //d += Double.NEGATIVE_INFINITY; // = NaN
        //d /= Double.POSITIVE_INFINITY; // = Nan

        System.out.println(d);

    }
}
