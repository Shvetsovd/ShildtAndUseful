package company.ocpjp2.$10_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 22.03.2018.
 */

class SimpleTestConnection{
    public static void main(String[] args) throws SQLException {

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "Nexponka999")){
            System.out.println(conn);
        }
    }
}

public class TestConnection {
    public static void main(String[] args) {
        final String dbURL = "jdbc:mysql://localhost:3306/zoo";
        final String userName = "root";
        final String pass = "Nexponka999";

        try {
            tryConnect(dbURL, userName, pass);
        } catch (SQLException e) {
            System.out.println("Unable to connect the Database: " + e.getMessage());
        }

    }

    private static void tryConnect(String db_url, String userName, String pass) throws SQLException {
        try(Connection connection = DriverManager.getConnection(db_url, userName, pass)){
            System.out.println(connection);
        }
    }
}

