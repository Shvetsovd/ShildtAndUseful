package company.ocpjp2.$6_ExceptionsAndAssertions;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * Created by user on 14.03.2018.
 */
public class Assertions {
    public void rethrowing() throws SQLException, DateTimeParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.err.println(e);
            throw e; // ok
        }
    }

    private void parseData() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws SQLException {
        new Assertions().rethrowing();
    }

}


