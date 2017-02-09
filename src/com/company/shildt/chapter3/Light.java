package company.shildt.chapter3;

/**
 * Created by user on 05.01.2017.
 */

// количество миль, проходимых светом, за 1000 дней

public class Light {
    public static void main(String[] args) {
        final int lightSpeed = 186000;
        long days, seconds, distance;

        days = 1000;
        seconds = days * 24 * 60 * 60;

        distance = lightSpeed * seconds;

        System.out.print("За " + days + " свет пройдет около ");
        System.out.println(distance + " миль");



    }
}
