package company.my.calculator.data;

import company.my.calculator.exceptions.StatementParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 21.03.2018.
 */
public class SimpleStatement extends Statement {
    private double a;
    private double b;
    private Operation operation;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Operation getOperation() {
        return operation;
    }

    public SimpleStatement(String statement) throws StatementParseException {
        super(statement);
    }

    @Override
    protected void parse(String statement) throws StatementParseException {
        String regexFullFormat = "\\s*\\d+\\s*[\\+\\-\\*\\/]\\s*\\d+\\s*";
        String regexBySign = "[\\+\\-\\*\\/]";

        try {
            if (!statement.matches(regexFullFormat)){
                throw new RuntimeException();
            }
            String[] args = statement.split(regexBySign);
            a = Double.parseDouble(args[0].trim());
            b = Double.parseDouble(args[1].trim());

            Pattern p = Pattern.compile(regexBySign);
            Matcher m = p.matcher(statement);
            if (!m.find()){
                throw new RuntimeException();
            }

            String op = statement.substring(m.start(), m.end());

            switch (op) {
                case "+":
                    operation = Operation.SUM;
                    break;
                case "-":
                    operation = Operation.SUBSTRACT;
                    break;
                case "*":
                    operation = Operation.MULTIPLY;
                    break;
                case "/":
                    operation = Operation.DIVIDE;
                    break;
                default:
                    throw new RuntimeException();

            }

        } catch (RuntimeException e) {
            //e.printStackTrace();
            throw new StatementParseException("Illegal statement format!");
        }


    }
}
