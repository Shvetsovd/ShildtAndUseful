package company.shildt.chapter12.annotations;

import java.lang.reflect.Method;

/**
 * Created by dmitry on 25.02.17.
 */
public class Single {

    @MySingle(100)
    public static void myMeth() {
        Single ob = new Single();

        try {

            Method m = ob.getClass().getMethod("myMeth");

            MySingle anno = m.getAnnotation(MySingle.class);

            System.out.println(anno.value());

        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
