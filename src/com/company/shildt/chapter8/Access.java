package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */

public class Access {
    static class A{
        int i;
        private int j;

        void setij(int x, int y){
            i = x;
            j = y;
        }
    }
    static class B extends A{
        int total;

        void sum(){
            //total = i + j;
        }
    }

    public static void main(String[] args) {
        B subOb = new B();

        subOb.setij(10, 12);
        subOb.sum();
        System.out.println("Сумма равна " + subOb.total);
    }
}
