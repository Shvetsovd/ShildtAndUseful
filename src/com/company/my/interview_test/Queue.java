package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class Queue {
    private static final int DEFAULT_SIZE = 10;

    private int[] data;
    int l;
    int r;

    public Queue() {
        data = new int[DEFAULT_SIZE];
        int l = -1;
        int r = -1;

    }

    public void add(int value) {
        if (r == data.length - 1) {
            grow();
        }
        data[++r] = value;
    }

    public int remove() {
        if (l >= r) {
            throw new EmtpyQueueException();
        }
        return data[++l];
    }

    private void grow() {
        int[] nData = new int[(r - l + 1) * 2];
        System.arraycopy(data, l + 1, nData, 0, r - l);
        data = nData;
    }
}
