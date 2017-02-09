package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class VarArgs {
    static void test(int...v){
        System.out.print("Количество аргументов: " + v.length +
        " Содержимое: ");

        for(int x : v){
            System.out.println(x);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(10);
        test(1, 2, 3);
        test();
    }
}
