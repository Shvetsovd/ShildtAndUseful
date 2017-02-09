package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class ByteUShift {
    public static void main(String[] args) {
        char hex[] = {
                '0', '1', '2','3','4','5','6','7',
                '8','9','A','B','C','D','E', 'F'
        };

        byte b = (byte) 0xF1; // 1111_0001
        byte c = (byte) (b >> 4); // 1111_1111 = 0xFF
        byte d = (byte) (b >>> 4); // 1111_1111 = 0xFF
        byte e = (byte) ((b & 0xFF) >> 4); //0000_1111 = 0x0F

        System.out.println(" b = 0x"
                    + hex[(b >> 4) & 0x0F] + hex[b & 0x0f]);
        System.out.println(" b >> 4 = 0x"
                    + hex[(c >> 4) & 0x0F] + hex[c & 0xF]);
        System.out.println(" b >>> 4 = 0x"
                    + hex[(d >> 4) & 0x0F] + hex[d & 0x0F]);
        System.out.println("(b & 0xFF) >> 4 = 0x"
                    + hex[(e >> 4) & 0x0f] + hex[e & 0x0F]);
    }
}
