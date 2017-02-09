package company.shildt.chapter4;

/**
 * Created by user on 11.01.2017.
 */

public class DexToBin {
    public static void main(String[] args) {
        int dex = 10;
        int d = dex;
        String binStr = "";

        do {
            binStr = String.valueOf(d % 2) + binStr;
            d /= 2;
        } while (d != 0);

        System.out.println(dex + " = " + binStr);
    }
}
