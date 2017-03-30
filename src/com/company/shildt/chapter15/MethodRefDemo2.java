package company.shildt.chapter15;

/**
 * Created by OPER on 30.03.2017.
 */
class MyStringOps2 {
    String strRevers(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo2 {
    static String stringOp(StringFunc3 sf, String str){
        return sf.func(str);
    }
    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        MyStringOps2 strOps = new MyStringOps2();

        outStr = stringOp(strOps::strRevers, inStr);

        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }

}
