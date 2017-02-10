package company.shildt.chapter10;

/**
 * Created by dmitry on 11.02.17.
 */
public class FinallyDemo {
    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Исключение перехвачено: " + e);
        }
        procB();
        procC();
    }

    private static void procC() {
        try {
            System.out.println("В теле метода procC()");
        } finally {
            System.out.println(
                    "Блок оператора finally в методе procC()"
            );
        }
    }

    private static void procB() {
        try {
            System.out.println("В теле метода procB()");
            return;
        } finally {
            System.out.println(
              "Блок оператора finally в методе procB()"
            );
        }
    }

    private static void procA() {
        try {
            System.out.println("В теле метода procA()");
            throw new RuntimeException("демонстрация");
        } finally {
            System.out.println(
                    "Блок оператора finally в методе procA()"
            );
        }
    }
}
