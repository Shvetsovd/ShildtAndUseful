package company.my.calculator.data;

import company.my.calculator.exceptions.StatementParseException;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by user on 21.03.2018.
 */
public abstract class Statement {
    public enum Operation{
        SUM,
        SUBSTRACT,
        MULTIPLY,
        DIVIDE
    }

    private String asString;

    public Statement(String statement) throws StatementParseException {
        this.asString = statement;
        parse(asString);
    }

    public String getAsString() {
        return asString;
    }

    protected abstract void parse(String statement) throws StatementParseException;
}
