package company.myUseful.generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 26.03.2017.
 */
public class Tmp {
    public static void main(String[] args) {
        List<Number> numList = new ArrayList<>();
        numList.add(0, new Integer(10));

        List rawList;
        rawList = numList;
        rawList.add(1, "123"); //Compile ok, but not right
        //Number num = numList.get(1); //ClassCastException

        numList = rawList;
        //numList.add(3, new File("/home/dmitry")); //Compile error (only Numbers we can add by using numList
        try {
            throw new IOException("We gonna die!");
        } catch (IOException e) {
            ConvException.<RuntimeException>throwAs(e);
        }



    }
}

class ConvException {
    static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e;
    }
}









