package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class PassArray {
    static void test(int v[]){
        System.out.println("Количество аргументов: " + v.length +
        " Содержимое: ");

        for(int x : v){ System.out.println(x + " "); }

        System.out.println();

    }

    public static void main(String[] args) {
        int n1[] = { 10 };
        int n2[] = { 1, 2, 3 };
        int n3[] = { };

        test(n1);
        test(n2);
        test(n3);
    }
}
