package company.shildt.chapter15;

import java.util.*;

/**
 * Created by OPER on 30.03.2017.
 */
class MyClass{
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
public class UseMethodRef {
    static int compareMC(MyClass a, MyClass b){
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        List<MyClass> a1 = new ArrayList<>();
        a1.add(new MyClass(1));
        a1.add(new MyClass(4));
        a1.add(new MyClass(2));
        a1.add(new MyClass(9));
        a1.add(new MyClass(3));
        a1.add(new MyClass(7));

        MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMC);
        //maxValObj = Collections.max(a1, (a, b) -> a.getVal() - b.getVal());
        //maxValObj = Collections.max(a1, Comparator.comparing(MyClass::getVal));

        System.out.println("Максимальное значение равно: " + maxValObj.getVal());
    }
}
