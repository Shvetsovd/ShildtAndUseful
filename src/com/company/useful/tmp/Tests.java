package company.useful.tmp;

/**
 * Created by OPER on 03.04.2017.
 */
public class Tests {
    public static void main(String[] args) {
        bitLogicTests();
        //incrementTests();
        //System.out.println(sumDigitsRecursive(123));
    }

    private static void bitLogicTests() {
        int x = Integer.MAX_VALUE;

        x <<= 1;
        //x = ~x;
        //x |= x;

        System.out.println(x);

        /*byte b = 64;
        int i;
        i = b << 2; //256
        b = (byte) (b<< 2); // 0
        System.out.println(i);
        System.out.println(i);*/


    }

    static int sumDigitsRecursive(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigitsRecursive(n / 10);
    }
    static void incrementTests(){
        int x = 0;

        x = ++x + --x;

        System.out.println(x);
    }
}
