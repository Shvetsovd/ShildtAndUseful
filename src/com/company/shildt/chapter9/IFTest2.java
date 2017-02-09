package company.shildt.chapter9;

/**
 * Created by dmitry on 08.02.17.
 */
public class IFTest2 {
    public static void main(String[] args) {
        DynStack myStack1 = new DynStack(5);
        DynStack mystack2 = new DynStack(8);

        for (int i = 0; i < 12; i++) {
            myStack1.push(i);
        }
        for (int i = 0; i < 20; i++) {
            mystack2.push(i);
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(myStack1.pop());
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.println(mystack2.pop());
        }
    }
}
