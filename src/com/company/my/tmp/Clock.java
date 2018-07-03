package company.my.tmp;

/**
 * Created by user on 19.05.2018.
 */
public class Clock {
    public static int getTimeAngle(int hours, int minutes) {
        checkTimeValues(hours, minutes);
        final int hScale = 360 / 12;
        final int mScale = 360 / 60;
        final double hmDelay = 12.;

        hours %= 12;
        double mAngle = mScale * minutes;
        double hAngle = hScale * hours + mAngle / hmDelay;
        return Math.abs((int)(hAngle - mAngle));

    }

    private static void checkTimeValues(int hours, int minutes) {
        if ((hours < 0 || hours > 23) || (minutes < 0 || minutes > 59)) {
            throw new IllegalArgumentException(
                    "Incorrect time values: " + hours + ":" + minutes
            );
        }
    }
}
