package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class QueueThreadSafe {
    public static void main(String[] args) {
        Q q = new Q();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    q.put(i);
                    System.out.println("put:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println("get: " + q.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

class Q{
    private Object value;
    public synchronized void put(Object o) throws InterruptedException {
        while (value != null){
            wait();
        }
        value = o;
        notifyAll();
    }
    public synchronized Object get() throws InterruptedException {
        while (value == null){
            wait();
        }
        Object result = value;
        value = null;
        notifyAll();
        return result;
    }

}
