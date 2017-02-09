package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */
public class UseSuper {
    static class A{
        int i;
    }
    static class B extends A{
        int i;

        B(int a, int b){
            super.i = a;
            i = b;
        }
        void show(){
            System.out.println("Член i в суперклассе: " + super.i);
            System.out.println("Член i в подклассе: " + i);
        }

        public static void main(String[] args) {
            B subOb = new B(1,2);
            subOb.show();
        }
    }
}
