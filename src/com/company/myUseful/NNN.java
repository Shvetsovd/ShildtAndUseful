package company.myUseful;

import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.StrictMath.*;


/**
 * Created by OPER on 12.06.2017.
 */
public class NNN {



}

class TrickyNum<X extends Number> {

    private X x;

    public TrickyNum(X x) {
        this.x = x;
    }

    private double getDouble() {
        return x.doubleValue();
    }

    public static void main(String args[]) {
        TrickyNum<Integer> a = new TrickyNum<Integer>(new Integer(1));
        System.out.print(a.getDouble());
    }
}






