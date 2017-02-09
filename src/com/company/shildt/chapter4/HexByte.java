package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class HexByte {
    public static void main(String[] args) {
        char hex[] = {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };

        byte b = (byte) 0xF1;

        System.out.println("b = 0x" + hex[(b >> 4) & 0x0F]
                                    + hex[b & 0x0F] );
    }
}
