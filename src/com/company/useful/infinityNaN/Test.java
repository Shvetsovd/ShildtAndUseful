package company.useful.infinityNaN;

/**
 * Created by OPER on 12.06.2017.
 */
public class Test {
    public static void main(String[] args) {
        double aPos = Double.POSITIVE_INFINITY;
        double aNeg = Double.NEGATIVE_INFINITY;

        System.out.println(aPos / aNeg);

        // один из операндов NaN = NaN
        // 0.0 * inf = NaN
        // inf / inf = NaN
        // inf - inf = NaN
        // 0.0 / 0.0 = NaN

    }
}
