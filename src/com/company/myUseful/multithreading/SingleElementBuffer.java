package company.myUseful.multithreading;

/**
 * Created by OPER on 28.04.2017.
 */
class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(Integer value) throws InterruptedException {
        while (elem != null){
            this.wait();
        }
        elem = value;
        notifyAll();
    }
    public synchronized int get() throws InterruptedException {
        while (elem == null){
            this.wait();
        }
        int result = elem;
        elem = null;
        notifyAll();
        return result;
    }
}
