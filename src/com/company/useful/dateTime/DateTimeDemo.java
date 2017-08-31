package company.useful.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by user on 04.07.2017.
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        System.out.println();

        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        System.out.println();

        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("HH':'mm':'ss', 'M")));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("HH':'mm':'ss', 'MM")));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("HH':'mm':'ss', 'MMM")));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("HH':'mm':'ss', 'MMMM")));

        System.out.println();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy', 'HH':'mm");
        LocalDateTime nyDateTime = LocalDateTime.parse(
                    "31-12-2017, 23:59", f);

        System.out.println(nyDateTime.format(f));

    }
}
