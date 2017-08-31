package company.useful.dateTime;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by OPER on 04.07.2017.
 */
public class Test1 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df;

        df = DateFormat.getTimeInstance();
        System.out.println("По умолчанию: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.SHORT);
        System.out.println("По умолчанию SHORT: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
        System.out.println("По умолчанию MEDIUM: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG);
        System.out.println("По умолчанию LONG: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.FULL);
        System.out.println("По умолчанию FULL: " + df.format(date));

        System.out.println();

        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);
        System.out.println("В формате США SHORT: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.US);
        System.out.println("В формате США MEDIUM: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.US);
        System.out.println("В формате США LONG: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.US);
        System.out.println("В формате США FULL: " + df.format(date));

        System.out.println();

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("В формате Канады FULL: " + df.format(date));


    }
}
