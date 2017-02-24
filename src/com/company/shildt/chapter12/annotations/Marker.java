package company.shildt.chapter12.annotations;

import java.lang.reflect.Method;

/**
 * Created by dmitry on 24.02.17.
 */
public class Marker {
    @MyMarker
    public static void myMeth(){
        Marker ob = new Marker();

        try {
            Method m = ob.getClass().getMethod("myMeth");

            if(m.isAnnotationPresent(MyMarker.class)){
                System.out.println("Аннотация-маркер MyMarker присутствует");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
