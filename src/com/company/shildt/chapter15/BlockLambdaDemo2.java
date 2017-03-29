package company.shildt.chapter15;

/**
 * Created by OPER on 29.03.2017.
 */
interface StringFunc {
    String func(String n);
}

public class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = (str) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            return sb.toString();
        };

        System.out.println("Лямбда обращается на " + reverse.func("Лямбда"));
        System.out.println("выражение обращается на " + reverse.func("Выражение"));
    }



}
