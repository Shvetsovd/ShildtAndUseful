package company.shildt.chapter9.p1;

import company.shildt.chapter9.p1.Protection;

/**
 * Created by dmitry on 07.02.17.
 */
class Derived extends Protection {
    Derived(){
        System.out.println("Конструктор подкласса класса");
        System.out.println("n = " + n);
        //System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
