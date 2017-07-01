package company.myUseful.currency;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.Currency.*;
import static java.util.Currency.getAvailableCurrencies;

/**
 * Created by OPER on 22.06.2017.
 */
public class Test {
    public static void main(String[] args) {

        //Currency c = Currency.getInstance(Locale.CHINA);
        Currency c = getInstance("THB");

        System.out.printf("%-20s %s\n", "Имя:", c.getDisplayName());
        System.out.printf("%-20s %s\n", "Символ:", c.getSymbol());
        System.out.printf("%-20s %s\n", "Код валюты:", c.getCurrencyCode());
        System.out.printf("%-20s %s\n", "Междунар. код:", c.getNumericCode());


        System.out.println("---");


        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
       /* TreeSet<Currency> sortedCurrencies = new TreeSet<>(new Comparator<Currency>() {
            @Override
            public int compare(Currency o1, Currency o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });
        sortedCurrencies.addAll(availableCurrencies);
        System.out.println(sortedCurrencies);*/

        Currency[] curs = new Currency[availableCurrencies.size()];
        availableCurrencies.toArray(curs);
        Arrays.sort(curs, 0, curs.length, new Comparator<Currency>() {
            @Override
            public int compare(Currency o1, Currency o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });

        int count = 0;
        for (Currency currency : curs) {
            Formatter frm = new Formatter();
            frm.format("%-40s\t%-3s", currency.getDisplayName(), currency.getCurrencyCode());
            System.out.println(frm);
            frm.close();
            count++;
        }


        System.out.println("---");
        System.out.println("Всего валют: " + count);


    }
}
