package company.myUseful.myException;

public class TestMyExceptions {
    public static void main(String[] args) {
        try {

            throw new MyModuleAException("Не дели на ноль", new ArithmeticException("Деление на ноль!"));
            //throw new MyModuleAException();

        } catch (MyApplicationException e) {

            System.out.println("Ошибка в модуле " + e.getErrorModuleName() + ": " + e);
            //MyModuleAException.errModuleString = "5";
            //System.out.println(e.getMessage() + " " + e.getCause().getMessage());
            //e.printStackTrace();

        }
    }

}
