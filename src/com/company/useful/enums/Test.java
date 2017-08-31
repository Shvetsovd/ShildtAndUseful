package company.useful.enums;

import com.sun.istack.internal.NotNull;

/**
 * Created by user on 06.04.2017.
 */
enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
public class Test {
    public static void main(String[] args) {
        DaysOfWeek day = DaysOfWeek.WEDNESDAY;
        System.out.println(getNextDay(day));
    }

    private static DaysOfWeek getNextDay(@NotNull DaysOfWeek day) {
        DaysOfWeek[] alldays = DaysOfWeek.values();

        return alldays[(day.ordinal() + 1)%alldays.length];
    }
}
