package company.shildt.chapter9;

/**
 * Created by dmitry on 07.02.17.
 */
public interface IntStack {
    void push(int item);
    int pop();

    default void clear() {
        throw new UnsupportedOperationException();
    }

}
