package company.shildt.chapter15;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyFunc {
    int func(int n);
}

public class VarCapture {
    private static int m = 0;
    public static void main(String[] args) {
        int num = 10;

        MyFunc myLambda = n -> {
            int v = num + n;
            //num++; //compile error
            m = 10; // ok
            return v;
        };
        //num = 9; //compile error
    }
}
