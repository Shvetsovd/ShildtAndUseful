package company.useful.multithreading;

/**
 * Created by user on 21.02.2017.
 */
public class NewRunnableTest2 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Выполняется в новом потоке");
                }
            }
        });

    }
}
