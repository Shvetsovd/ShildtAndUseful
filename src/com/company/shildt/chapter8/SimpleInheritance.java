package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */


class SimpleInheritance {
    static class A {
        int i, j;

        void showij(){
            System.out.println("i и j: " + i + " " + j);
        }
    }
    static class B extends A {
        int k;

        void showk(){
            System.out.println("k: " + k);
        }
        void sum(){
            System.out.println("i + j + k: " + (i + j + k));
        }
    }
    public static void main(String[] args) {
        A superOb = new A();
        A superOb1 = new A();
        B subOb = new B();

        superOb.i = 10;
        superOb.j = 20;
        System.out.println("Содержимое объекта superOb: ");
        superOb.showij();

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;

        System.out.println("Содержимое объекта subOb: ");
        subOb.showij();
        subOb.showk();

        System.out.println();
        System.out.println("Сумма i, j, k в объекте subOb: ");
        subOb.sum();
    }

}
