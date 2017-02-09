package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */
public class Override {
    static class A {
        int i, j;

        A(int a, int b) {
            i = a;
            j = b;
        }

        void show() {
            System.out.println("i и j: " + i + " " + j);
        }
    }

    static class B extends A {
        int k;

        B(int a, int b, int c) {
            super(a, b);
            k = c;
        }

        void show(String msg) {
            System.out.println(msg + k);
        }
    }

    public static void main(String[] args) {
        B subob = new B(1, 2, 3);
        subob.show("Это к: ");
        subob.show();
    }
}
