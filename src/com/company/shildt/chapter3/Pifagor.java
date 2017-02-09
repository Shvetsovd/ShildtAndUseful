package company.shildt.chapter3;

/**
 * Created by user on 09.01.2017.
 */

public class Pifagor {
    public static void main(String[] args) {
        try {
            //double a = Double.parseDouble(args[0]);
            //double b = Double.parseDouble(args[1]);
            double a = 4.0;
            double b = 5.0;

            double c = Math.sqrt(a * a + b * b);
            System.out.println("Гипотенуза равна: " + c);

            System.console().readLine();
        }
        catch (Exception e){
            System.out.println("Ошибка! Подробности: " + e.getMessage());
        }
    }

}
