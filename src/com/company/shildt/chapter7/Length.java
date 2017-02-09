package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class Length {
    public static void main(String[] args) {
        int a1[] = new int[10];
        int a2[] = { 3, 5, 7, 1, 8, 99, 44, -10 };
        int a3[] = { 4, 3, 2, 1 };
        int a4[][] = {
                { 1, 2 },
                { 3, 4 }
        };
        System.out.println("длина a1 равна " + a1.length);
        System.out.println("длина а2 равна " + a2.length);
        System.out.println("длина а3 равна " + a3.length);
        System.out.println("длина а4 равна " + a4.length);

    }
}
