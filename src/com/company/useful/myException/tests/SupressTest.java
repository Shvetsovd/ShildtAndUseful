package company.useful.myException.tests;

/**
 * Created by user on 25.04.2017.
 */
public class SupressTest implements AutoCloseable{
    public static void main(String[] args) {
        try(SupressTest x = new SupressTest()){
            throw new ArithmeticException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        throw new IllegalArgumentException();
    }
}

/*
java.lang.ArithmeticException
        at company.useful.myException.tests.SupressTest.main(SupressTest.java:9)
        ...
        Suppressed: java.lang.IllegalArgumentException
        ...
*/
