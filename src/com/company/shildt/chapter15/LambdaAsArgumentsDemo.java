package company.shildt.chapter15;

/**
 * Created by OPER on 29.03.2017.
 */
interface StringFunc2 {
    String func(String n);
}

public class LambdaAsArgumentsDemo {
    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);
        outStr = stringOp((str) -> str.toUpperCase(), inStr);

        System.out.println("Это строка в верхнем регистре: " + outStr);

        outStr = stringOp((s) -> {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)!=' '){
                    result += s.charAt(i);
                }
            }
            return result;
        }, inStr);

        System.out.println("Это строка с удаленными пробелами: " + outStr);

        StringFunc2 reverse = str -> {
          String result = " ";
            for (int i = str.length()-1; i >= 0 ; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Это обращенная строка: " + stringOp(reverse, inStr));
    }
}
