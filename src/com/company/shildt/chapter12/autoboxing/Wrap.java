package company.shildt.chapter12.autoboxing;

import company.shildt.chapter9.IntStack;

/**
 * Created by dmitry on 24.02.17.
 */
public class Wrap {
    public static void main(String[] args) {
        Integer iOb = new Integer(100);
        int i = iOb.intValue();

        System.out.println(i + " " + iOb);
    }
}
