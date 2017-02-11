package company.shildt.chapter10;

import javax.sound.midi.Soundbank;

/**
 * Created by dmitry on 11.02.17.
 */
public class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }
}

class Exceptiondemo {
    static void compute(int a) throws MyException {
        System.out.println("Вызван метод compute(" + a + ")");

        if (a > 10) {
            throw new MyException(a);
        }

        System.out.println("Нормальное заершение");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
