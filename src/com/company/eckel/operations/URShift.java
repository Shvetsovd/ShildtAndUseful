package company.eckel.operations;

public class URShift {
    public static void main(String[] args) {
        int i = -1;
        System.out.println("int i = -1:\t\t" + Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println("i >>>= 10:\t\t" + Integer.toBinaryString(i));
        long l = -1;
        System.out.println("long l = -1:\t" + Long.toBinaryString(l));
        l >>>= 10;
        System.out.println("l >>>= 10;\t\t" + Long.toBinaryString(l));
        short s = -1;
        System.out.println("short s = -1:\t" + Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println("s >>>= 10:\t\t" + Integer.toBinaryString(s));
        byte b = -1;
        System.out.println("byte b = -1:\t" + Integer.toBinaryString(b));
        b >>>= 10;
        System.out.println("b >>>= 10:\t\t" + Integer.toBinaryString(b));
        b = -1;
        System.out.println("b = -1:\t\t\t" + Integer.toBinaryString(b));
        System.out.println("Integer.toBinaryString(b>>>10):\n\t\t\t\t" + Integer.toBinaryString(b>>>10));
    }
}
