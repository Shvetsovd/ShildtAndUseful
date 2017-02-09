package company.shildt.chapter9.p2;


/**
 * Created by dmitry on 07.02.17.
 */
public class OtherPackage {
    OtherPackage() {
        company.shildt.chapter9.p1.Protection p = new company.shildt.chapter9.p1.Protection();

        System.out.println(
                "Конструктор из другого пакета");
        //System.out.println("n = " + p.n);
        //System.out.println("n_pri = " + p.n_pri);
        //System.out.println("n_pro = " + p.n_pro);
        System.out.println("n_pub = " + p.n_pub);
    }
}
