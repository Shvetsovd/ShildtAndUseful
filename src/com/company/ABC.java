package company;

import company.myUseful.myException.MyApplicationException;
import company.myUseful.myException.MyModuleAException;

/**
 * Created by OPER on 08.02.2017.
 */
public class ABC {
    public static void main(String[] args) {
        int a = 0;
    }

    public void meth() {
        try {
            throw new MyModuleAException();
        } catch (MyApplicationException e) {
            e.printStackTrace();
        }

    }
}

