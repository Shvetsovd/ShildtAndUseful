package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class BitLogic {
    public static void main(String[] args) {
        String binary[] = {
                "0000", "0001", "0010", "0011", "0100", "0101",
                "0110", "0111", "1000", "1001", "1010", "1011",
                "1100", "1101", "1110", "1111"
        };
        int a = 3; //0000_0011
        int b = 6; //0000_0110
        int c = a | b; //0000_0111 = 7
        int d = a & b; //0000_0010 = 2
        int e = a ^ b; //0000_0101 = 5;
        int f = (~a & b) | (a & ~b); // (1111_1100 & 0000_0110) | (0000_0011 & 1111_1001) = 0000_0100 | 0000_0001 = 000_0101 = 5;
        int g = ~a & 0x0f; // 1111_1100 & 0000_1111 = 0000_1100 = 3
        System.out.println(" a = " + binary[a]);
        System.out.println(" b = " + binary[b]);
        System.out.println(" a|b = " + binary[c]);
        System.out.println(" a&b = " + binary[d]);
        System.out.println(" a^b = " + binary[e]);
        System.out.println("~a&b|a&~b = " + binary[f]);
        System.out.println(" ~a = " + binary[g]);
    }
}
