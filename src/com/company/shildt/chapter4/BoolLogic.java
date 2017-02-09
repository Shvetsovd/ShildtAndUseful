package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class BoolLogic {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = a | b;
        boolean d = a & b;
        boolean e = a ^ b;
        boolean f = (!a & b) | (a & !b);
        boolean g = !a;

        System.out.println("        a = " + a); //true
        System.out.println("        b = " + b); //false
        System.out.println("      a|b = " + c); //true
        System.out.println("      a&b = " + d); //false
        System.out.println("      a^b = " + e); //true
        System.out.println("!a&b|a&!b = " + f); //true
        System.out.println("       !a = " + g); // false
    }
}
