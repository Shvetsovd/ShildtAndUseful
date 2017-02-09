package company.shildt.chapter9.p1;

import company.shildt.chapter9.p1.Protection;

/**
 * Created by dmitry on 07.02.17.
 */
class SamePackage {
    SamePackage() {
        Protection p = new Protection();
        System.out.println("Конструктор этого же пакета");
        System.out.println("n = " + p.n);
        //System.out.println("n_pri = " + p.n_pri);
        System.out.println("n_pro = " + p.n_pro);
        System.out.println("n_pub = " + p.n_pub);
    }
}
