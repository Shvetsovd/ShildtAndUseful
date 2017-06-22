package company.myUseful.dateTime;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by OPER on 22.06.2017.
 */
public class TimeDifference {
    private static final long SECOND_IN_MILLIS = 1000;
    private static final long MINUTE_IN_MILLIS = 60 * SECOND_IN_MILLIS;
    private static final long HOUR_IN_MILLIS = 60 * MINUTE_IN_MILLIS;
    private static final long DAY_IN_MILLIS = 24 * HOUR_IN_MILLIS;

    private String msg;

    public static void main(String args[]) throws ParseException {

        new TimeDifference("До конца смены осталось:", "2017-06-22-19-00-00");

    }

    public TimeDifference(String msg, String destTime) throws ParseException {
        this.msg = msg;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date dest = format.parse(destTime);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          showTimeDifference(dest, msg);
                                      }
                                  },
                0,
                1000);
    }


    void showTimeDifference(Date destTime, String msg) {

        long now = System.currentTimeMillis();
        long dest = destTime.getTime();

        long diff = dest - now;

        long days = diff / DAY_IN_MILLIS;
        diff -= days * DAY_IN_MILLIS;

        long hours = diff / HOUR_IN_MILLIS;
        diff -= hours * HOUR_IN_MILLIS;

        long minutes = diff / MINUTE_IN_MILLIS;
        diff -= minutes * MINUTE_IN_MILLIS;

        long seconds = diff / SECOND_IN_MILLIS;


        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.println(msg);
        System.out.println(days + " дн. " + hours + " ч. " + minutes + " мин. " + seconds + " сек. ");
    }
}
