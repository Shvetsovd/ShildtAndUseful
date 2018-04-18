package company.my.interview_test;

import java.util.EmptyStackException;

/**
 * Created by user on 14.04.2018.
 */
public class Stack {
    private static final int DEFAULT_SIZE = 10;
    int[] data;
    int tos;

    public Stack() {
        data = new int[DEFAULT_SIZE];
        tos = -1;
    }

    public void push(int value) {
        if (tos == data.length - 1) {
            grow();
        }
        data[++tos] = value;
    }

    public int pop() {
        if (tos == -1) {
            throw new EmptyStackException();
        }
        return data[tos--];
    }

    public int peek() {
        if (tos == -1) {
            throw new EmptyStackException();
        }
        return data[tos];
    }

    private void grow() {
        int[] nData = new int[data.length * 2];
        System.arraycopy(data, 0, nData, 0, data.length);
    }
}
