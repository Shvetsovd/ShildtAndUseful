package company;

import company.myUseful.myException.MyApplicationException;
import company.myUseful.myException.MyModuleAException;

/**
 * Created by OPER on 08.02.2017.
 */
public class ABC {
    public static void main(String[] args) {

        int x = 0;

        x = ++x + ++x;
        System.out.println(x);
    }

    public void meth() {
        try {
            throw new MyModuleAException();
        } catch (MyApplicationException e) {
            e.getErrorModuleName();
        }

    }
}

