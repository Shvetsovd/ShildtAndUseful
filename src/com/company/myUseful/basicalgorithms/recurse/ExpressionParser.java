package company.myUseful.basicalgorithms.recurse;

/**
 * Created by OPER on 21.04.2017.
 */
public class ExpressionParser {
    public static void main(String[] args) {
        System.out.println(parse("(5*(2*10)+(10/5)-2)^2"));
        System.out.println(parse("5^2"));
    }

    private static int parse(String expr) {
        int result = 0;
        if (expr.startsWith("(")) {
            int braceCounter = 1;
            int pos = 0;
            while (braceCounter != 0) {
                pos++;
                if (pos == expr.length()) {
                    throw new IllegalArgumentException("Expression is not valid");
                }
                if (expr.charAt(pos) == '(') braceCounter++;
                if (expr.charAt(pos) == ')') braceCounter--;
            }
            int inBraceValue = parse(expr.substring(1, pos));
            result = parse(inBraceValue + expr.substring(pos + 1, expr.length()));

        } else {
            int pos = 0;
            while (pos != expr.length() && Character.isDigit(expr.charAt(pos))) {
                pos++;
            }

            int leftOperand = Integer.valueOf(expr.substring(0, pos));
            if (pos == expr.length()){
                return leftOperand;
            }
            char operation = expr.charAt(pos);
            int rightOperand = parse(expr.substring(pos + 1, expr.length()));

            switch (operation) {
                case '^':
                    result = (int)Math.pow(leftOperand, rightOperand);
                    break;
                case '*':
                    result = leftOperand * rightOperand;
                    break;
                case '/':
                    result = leftOperand / rightOperand;
                    break;
                case '%':
                    result = leftOperand % rightOperand;
                    break;
                case '+':
                    result = leftOperand + rightOperand;
                    break;
                case '-':
                    result = leftOperand - rightOperand;
            }
        }
        return result;
    }
}
