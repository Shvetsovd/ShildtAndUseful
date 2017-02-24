package company.shildt.chapter12.annotations;

import java.lang.reflect.Method;

/**
 * Created by dmitry on 24.02.17.
 */
public class Meta {

    @MyAnno(str = "Два параметра", val = 19)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();

        try {

            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMeth", String.class, int.class);

            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());

        } catch (NoSuchMethodException e) {

            System.out.println("Метод не найден");

        }
    }

    public static void main(String[] args) {
        myMeth("Тест", 10);
    }

}
