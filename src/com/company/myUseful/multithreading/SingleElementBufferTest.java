package company.myUseful.multithreading;

/**
 * Created by OPER on 28.04.2017.
 */
public class SingleElementBufferTest {
    public static void main(String[] args) {
        SingleElementBuffer q = new SingleElementBuffer();
        new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    q.put(value);
                    System.out.println("put: " + value++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                try {
                    System.out.println("get: " + q.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
