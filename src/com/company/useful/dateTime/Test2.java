package company.useful.dateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 04.07.2017.
 */
public class Test2 {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf;

        sdf = new SimpleDateFormat("dd-MM-yyyy -> hh:mm:ss z");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("dd-MMM-yyyy E -> HH:mm:ss zzz");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("dd-MMM-YYYY E -> HH:mm:ss Z");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("dd-MMM-YYYY E -> HH:mm:ss X");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("DD-dd-MMM-YYYY E -> HH:mm:ss.SS");
        System.out.println(sdf.format(date));
    }
}
