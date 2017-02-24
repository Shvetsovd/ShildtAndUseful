package company.shildt.chapter12.enums;

/**
 * Created by dmitry on 24.02.17.
 */
public class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;

        System.out.println("Константы перечислимого типа Apple:");

        Apple allApples[] = Apple.values();
        for(Apple a : allApples){
            System.out.println(a);
        }

        System.out.println();

        ap = Apple.valueOf("Winesap");
        System.out.println("Переменная ap содержит: " + ap);
    }
}
