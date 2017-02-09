package company.shildt.chapter9;

/**
 * Created by dmitry on 08.02.17.
 */
public class DynStack implements IntStack {
    private int stck[];
    private int tos;

    DynStack(int size) {
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
        if (tos == stck.length - 1) {
            int tmp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) {
                tmp[i] = stck[i];
            }
            stck = tmp;
        }
        stck[++tos] = item;
    }

    @Override
    public int pop() {
        if (tos >= 0 ){
            return stck[tos--];
        }else {
            throw new IllegalArgumentException();
        }
    }
}
