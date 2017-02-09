package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class VarArgs2 {
    static void test(String msg, int...v){
        System.out.print(msg + v.length + " Содержимое: ");

        for (int x : v){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test("Один параметр переменной длины: ", 10);
        test("Три параметра переменной длины: ", 1, 2, 3);
        test("Без параметров переменной длины: ");
    }
}
