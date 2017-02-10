package company.shildt.chapter10;

public class TestMyException{
    public static void main(String[] args) {
        try {
            throw new MyException("Ошибка в модуле А: ", new ArithmeticException("Деление на ноль!"));
        } catch (MyException e) {
            System.out.println(e.getMessage() + " " + e.getCause().getMessage());
        }
    }

}
