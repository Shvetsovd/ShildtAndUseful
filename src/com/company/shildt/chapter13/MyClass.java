package company.shildt.chapter13;

/**
 * Created by dmitry on 11.03.17.
 */
public class MyClass {
    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public MyClass(int i) {
        this(i, i);
    }

    public MyClass() {
        this(0);
    }
}
