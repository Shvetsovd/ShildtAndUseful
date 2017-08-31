package company.useful.javadocs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * В этом классе демонстрируется применение
 * документирующих комментариев.
 *
 * @author Герберт Шилдт
 * @version 1.0
 */
public class SquareNum {
    /**
     * Этот метод возвращает квадрат числа.
     * Это многострочное описание. В нем можно ввести столько строк,
     * сколько потребуется
     *
     * @param num Значение, которое требуется возвести в квадрат.
     * @return num Значение, возведенное в квадрат
     */
    public double square(double num) {
        return num * num;
    }

    /**
     * Этот метод считывает число, введенное пользователем в консоль.
     *
     * @return Введенное число типа double
     * @throws IOException Если при вводе возникает ошибка,
     *                     то генерируется исключение типа IOEXception
     * @see IOException
     */
    public double getNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();
        return Double.parseDouble(value);
    }

    /**
     * Этот метод демонстрирует применение метода square()
     *
     * @param args Неиспользуется
     * @throws IOException Если при вводе возникает ошибка,
     *                     то генерируется исключение типа IOException
     * @see IOException
     */
    public static void main(String[] args) throws IOException {
        SquareNum sn = new SquareNum();
        double value;
        System.out.println("Введите значение для возведения в квадрат: ");
        value = sn.getNumber();
        value = sn.square(value);
        System.out.println("Квадрат значения равен: " + value);
    }
}
