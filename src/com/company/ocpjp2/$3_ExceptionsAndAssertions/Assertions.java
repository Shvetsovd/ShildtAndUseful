package company.ocpjp2.$3_ExceptionsAndAssertions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

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


