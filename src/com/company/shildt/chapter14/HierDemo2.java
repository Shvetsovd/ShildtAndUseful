package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class _NonGen {
    private int num;

    _NonGen(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

class _Gen<T> extends _NonGen {
    private T ob;

    _Gen(T o, int i) {
        super(i);
        ob = o;
    }

    public T getOb() {
        return ob;
    }
}

public class HierDemo2 {
    public static void main(String[] args) {
        _Gen<String> w = new _Gen<>("Добро пожаловать ", 47);
        System.out.print(w.getOb());
        System.out.println(w.getNum());
    }
}
