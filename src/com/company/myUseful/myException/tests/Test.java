package company.myUseful.myException.tests;

/**
 * Created by user on 05.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(method());
    }

    static int method() {
        System.out.println("method()");
        try{
            return 0;
        }finally {
            return 1;
        }
    }
}
