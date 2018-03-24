package company.ocpjp2.$10_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 22.03.2018.
 */
public class SetupMySQLTestBase {
    public static void main(String[] args) throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost:3306/";
        try (Connection connection = DriverManager.getConnection(DB_URL, "root", "Nexponka999");
             Statement stmnt = connection.createStatement();) {


            //Create database "zoo"
            stmnt.executeUpdate("CREATE DATABASE zoo");
            stmnt.executeUpdate("USE zoo");

            //Create and fill table "animal"
            stmnt.executeUpdate("CREATE TABLE animal (" +
                    "id INTEGER PRIMARY KEY," +
                    "species_id INTEGER," +
                    "name VARCHAR(255)," +
                    "date_born TIMESTAMP)");
            stmnt.executeUpdate("INSERT INTO animal VALUES(1, 1, 'Elsa', '2001-05-06 02:15')");
            stmnt.executeUpdate("INSERT INTO animal VALUES(2, 2, 'Zelda', '2002-08-15 09:12')");
            stmnt.executeUpdate("INSERT INTO animal VALUES(3, 1, 'Ester', '2002-09-09 10:36')");
            stmnt.executeUpdate("INSERT INTO animal VALUES(4, 1, 'Eddie', '2010-06-08 01:24')");
            stmnt.executeUpdate("INSERT INTO animal VALUES(5, 2, 'Zoe', '2005-11-12 03:44')");

            //Create and fill table "species"
            stmnt.executeUpdate("CREATE TABLE species (" +
                    "id INTEGER PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "num_acres DECIMAL(2,1))");
            stmnt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmnt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");


        }
    }
}
