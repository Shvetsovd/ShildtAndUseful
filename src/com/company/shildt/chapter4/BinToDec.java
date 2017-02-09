package company.shildt.chapter4;

/**
 * Created by user on 11.01.2017.
 */

public class BinToDec {

    public static void main(String[] args) {
        String binStr = "1110010";

        int dex = 0;
        for (int i = 0; i < binStr.length(); i++){
            dex += Integer.parseInt(binStr.substring(i, i+1)) * pow2(binStr.length() - i - 1);
        }

        System.out.println(binStr + " = " + dex);
    }

    public static int pow2(int p){
        int result = 1;
        for (int i = 0; i < p; i++){
            result *= 2;
        }
        return result;
    }
}
