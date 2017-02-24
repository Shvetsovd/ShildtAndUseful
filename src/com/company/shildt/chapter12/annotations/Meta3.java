package company.shildt.chapter12.annotations;

import java.lang.reflect.Method;

/**
 * Created by dmitry on 24.02.17.
 */
public class Meta3 {
    public static void main(String[] args) {
        myMeth();
    }

    @MyAnno()
    private static void myMeth() {
        Meta3 ob = new Meta3();

        Class<?> c = ob.getClass();
        /*Method[] m = c.getDeclaredMethods();
        for (Method meth : m)
            System.out.println(meth.getName());*/

        try {
            Method m = c.getDeclaredMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }


    }
}
