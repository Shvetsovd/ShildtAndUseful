package company.shildt.chapter10;

import java.io.FileNotFoundException;

/**
 * Created by dmitry on 10.02.17.
 */
public class SuperSubCatch {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int a = 0;
            int b = 42 / a;
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.out.println("Перехват исключений общего класса Exception");
            throw e;
        }/* catch (ArithmeticException e) {
            System.out.println("Этот код вообще недостижим");
        }*/
    }

}
