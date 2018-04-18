package company.my.interview_test;

/**
 * Created by user on 14.04.2018.
 */
public class TimeUtilities {
    public static int getTimeAngle(int hours, int minutes) {
        checkTimeValues(hours, minutes);

        final int hScale = 360 / 12;
        final int mScale = 360 / 60;

        int mAngle = minutes * mScale;
        int delta = mAngle / 12;
        int hAngle = (hours % 12) * hScale + delta;

        return Math.abs(hAngle - mAngle);

    }

    private static void checkTimeValues(int hours, int minutes) {
        if ((hours < 0 || hours > 23) || (minutes < 0 || minutes > 59)) {
            throw new IllegalArgumentException();
        }
    }
}

class TimeTest {
    public static void main(String[] args) {
        System.out.println(TimeUtilities.getTimeAngle(21, 0));
    }
}
