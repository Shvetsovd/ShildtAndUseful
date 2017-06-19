package company.myUseful;

import java.lang.reflect.Constructor;

/**
 * Created by OPER on 12.06.2017.
 */
public class NNN {

    public static void main(String args[]){

    }



}

class TrickyNum<X extends Number> {

    private X x;

    public TrickyNum(X x) {
        this.x = x;
    }

    private double getDouble() {
        return x.doubleValue();
    }

    public static void main(String args[]) {
        TrickyNum<Integer> a = new TrickyNum<Integer>(new Integer(1));
        System.out.print(a.getDouble());
    }
}






