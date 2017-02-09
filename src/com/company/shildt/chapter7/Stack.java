package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
class Stack {
    private int stck[];
    private int tos = -1;

    Stack(int size) throws IllegalArgumentException{
        if(size > 0) {
            tos = -1;
            stck = new int[size];
        }
        else {
            throw new IllegalArgumentException("Размер стека должен быть больше 0");
        }
    }

    void push(int item) {
        if (tos == (stck.length - 1)) {
            System.out.println("Стек заполнен.");
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Стек пуст.");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}

class StackTest {
    public static void main(String[] args) {
        Stack mystack1 = new Stack(10);
        Stack mystack2 = new Stack(10);

        for (int i = 0; i < 10; i++) {
            mystack1.push(i);
        }
        for (int i = 10; i < 20; i++) {
            mystack2.push(i);
        }

        System.out.println("Стек в mystack1:");
        for (int i = 0; i < 10; i++) {
            System.out.print(mystack1.pop() + " ");
        }

        System.out.println("\nСтек в mystack2:");
        for (int i = 0; i < 10; i++) {
            System.out.print(mystack2.pop() + " ");
        }

        //mystack1.tos = -2;
        //mystack2.stck[3] = 100;

    }
}
