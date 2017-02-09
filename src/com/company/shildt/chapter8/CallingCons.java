package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */
public class CallingCons {
    static class A{
        A(){
            System.out.println("В конструкторе А.");
        }
    }

    static class B extends A{
        B(){
            System.out.println("В конструкторе В.");
        }
    }
    static class C extends B{
        C(){
            System.out.println("В конструкторе С.");
        }
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
