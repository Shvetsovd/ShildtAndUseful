package company.my.calculator.interfaces;

import company.my.calculator.exceptions.StatementExecuteException;

/**
 * Created by user on 21.03.2018.
 */
public interface Model {
    double calculate(String statement) throws StatementExecuteException;
}
