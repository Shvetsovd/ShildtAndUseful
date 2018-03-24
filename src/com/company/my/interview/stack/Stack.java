package company.my.interview.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by user on 23.03.2018.
 */
public class Stack {
    private static final int START_SIZE = 10;
    private int[] data;
    private int tos;

    public Stack() {
        data = new int[START_SIZE];
        tos = -1;
    }

    public void push(int value) {
        if (tos == data.length - 1) {
            grow();
        }
        data[++tos] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[tos--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    private void grow() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}

