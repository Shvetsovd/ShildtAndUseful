package company.my.interview.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by user on 23.03.2018.
 */
public class GStack<T> {

    private static final int START_SIZE = 10;
    private T[] data;
    private int tos;

    @SuppressWarnings("unchecked")
    public GStack() {
        data = (T[]) new Object[START_SIZE];
        tos = -1;
    }

    public void push(T value) {
        if (tos == data.length - 1) {
            grow();
        }
        data[++tos] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[tos--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}


