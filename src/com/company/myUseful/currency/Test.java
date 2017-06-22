package company.myUseful.currency;

import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by OPER on 22.06.2017.
 */
public class Test {
    public static void main(String[] args) {

        //Currency c = Currency.getInstance(Locale.CHINA);
        Currency c = Currency.getInstance("RUB");

        System.out.printf("%-20s %s\n", "Имя:", c.getDisplayName());
        System.out.printf("%-20s %s\n", "Символ:", c.getSymbol());
        System.out.printf("%-20s %s\n", "Код валюты:", c.getCurrencyCode());
        System.out.printf("%-20s %s\n", "Междунар. код:", c.getNumericCode());


        System.out.println("---");

        int count = 0;
        for (Currency currency : Currency.getAvailableCurrencies()) {
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
