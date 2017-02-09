package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
public class VarArgs5 {
    static void vaTest(){
        System.out.println("vaTest( )");
    }
    static void vaTest(int a){
        System.out.println("vaTest(int a)");
    }
    static void vaTest(int a, int b){
        System.out.println("vaTest(int a, int b)");
    }
    static void vaTest(int ... v){
        System.out.println("vaTest(int ... v)");
    }
    static void vaTest(boolean ... v){
        System.out.println("vaTest(boolean ... v)");
    }

    public static void main(String[] args) {
        vaTest();
        vaTest(1);
        vaTest(1, 2);
        vaTest(1, 2, 3);
        vaTest(true, false, false);
    }
}
