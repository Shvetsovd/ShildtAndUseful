package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class ByteShift {
    public static void main(String[] args) {
        byte a = 64, b;
        int i;

        i = a << 2;
        b = (byte) (a << 2);

        System.out.println("Первоначальное значение а: " + a);
        System.out.println("i and b: " + i + " " + b);
    }
}
