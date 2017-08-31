package company.useful.multithreading;

/**
 * Created by user on 21.02.2017.
 */
public class NewThreadTest2 {
    public static void main(String[] args) {

        Thread thread = new Thread(
                ()-> {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Выполняется в новом потоке");
                    }
                });
        thread.start();

    }
}
