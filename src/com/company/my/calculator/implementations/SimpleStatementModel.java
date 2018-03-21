package company.my.calculator.implementations;

import company.my.calculator.data.SimpleStatement;
import company.my.calculator.data.Statement;
import company.my.calculator.exceptions.StatementExecuteException;
import company.my.calculator.exceptions.StatementParseException;
import company.my.calculator.interfaces.Model;

/**
 * Created by user on 21.03.2018.
 */
public class SimpleStatementModel implements Model {
    @Override
    public double calculate(String statement) throws StatementExecuteException {
        SimpleStatement stmnt;

        try {
            stmnt = new SimpleStatement(statement);
        } catch (StatementParseException e) {
            throw new StatementExecuteException(e.getMessage());
        }
        double a = stmnt.getA();
        double b = stmnt.getB();

        switch (stmnt.getOperation()) {
            case SUM:
                return a + b;
            case SUBSTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
            default:
                throw new StatementExecuteException("Unsupport statement operation");
        }

    }
}
