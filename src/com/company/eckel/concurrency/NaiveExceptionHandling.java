package company.eckel.concurrency;//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}

import java.util.concurrent.*;

public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec =
                    Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            // This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
} /*
Exception in thread "pool-1-thread-1" java.lang.RuntimeException...
*/ //:~
