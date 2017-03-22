package company.myUseful.generics;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OPER on 22.03.2017.
 */
public class Stack<T> {
    private static final int DEFAULT_SIZE = 3;
    private List<T> storage;
    private int tos;

    public Stack() {
        storage = new ArrayList<T>(DEFAULT_SIZE);
        tos = -1;
    }

    public void push(T value) {
        storage.add(value);
        tos++;
    }

    @Nullable
    public T pop() {
        if (tos < 0) {
            return null;
        }
        T value = storage.get(tos);
        storage.remove(tos);
        tos--;
        return value;
    }

    public T[] getStackTrace(){
        return (T[])storage.toArray();
    }
}