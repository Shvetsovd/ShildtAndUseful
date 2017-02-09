package company.shildt.chapter9;

/**
 * Created by dmitry on 07.02.17.
 */
public class FixedStack implements IntStack {
    private int stck[];
    private int tos;

    public FixedStack(int size) {
        if (stck == null) {
            stck = new int[size];
            tos = -1;
        }
    }

    @Override
    public void push(int item) {
        if (stck == null) {
            throw new NullPointerException();
        }

        if (tos == (stck.length - 1)) {
            throw new StackOverflowError();
        } else {
            stck[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos >= 0) {
            return stck[tos--];
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
