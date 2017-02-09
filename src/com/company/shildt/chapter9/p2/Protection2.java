package company.shildt.chapter9.p2;

import company.shildt.chapter9.p1.Protection;

/**
 * Created by dmitry on 07.02.17.
 */
public class Protection2 extends company.shildt.chapter9.p1.Protection {
    Protection2() {
        System.out.println(
                "Конструктор, унаследованный из другого пакета");
        //System.out.println("n = " + n);
        //System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
