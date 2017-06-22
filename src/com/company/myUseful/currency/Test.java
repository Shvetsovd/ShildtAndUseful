package company.myUseful.currency;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by OPER on 22.06.2017.
 */
public class Test {
    public static void main(String[] args) {

        //Currency c = Currency.getInstance(Locale.CHINA);
        Currency c = Currency.getInstance("RUB");

        System.out.println(c.getDisplayName());
        System.out.println(c.getSymbol());
        System.out.println(c.getCurrencyCode());
        System.out.println(c.getNumericCode());

        System.out.println("---");

        for (Currency currency : Currency.getAvailableCurrencies()) {
            System.out.println(currency.getDisplayName() + " " + currency.getCurrencyCode());
        }


    }
}
