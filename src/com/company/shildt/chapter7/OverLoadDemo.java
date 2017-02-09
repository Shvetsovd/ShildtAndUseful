package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */
class OverLoadDemo {
    void test(){
        System.out.println("Параметры отсутствуют");
    }
    void test(int a, int b){
        System.out.println("a и b: " + a + " " + b);
    }
    void test (double a){
        System.out.println(
                "Внутреннее преобразование test(double) a: " + a);
    }
}
class Overload{
    public static void main(String[] args) {
        OverLoadDemo ob = new OverLoadDemo();
        int i = 88;

        ob.test();
        ob.test(10, 20);
        ob.test(i);
        ob.test(123.25);
    }
}
