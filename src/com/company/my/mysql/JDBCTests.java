package company.my.mysql;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.*;

/**
 * Created by user on 21.03.2018.
 */
public class JDBCTests {
    public static void main(String[] args) throws SQLException {
        final String DB_URL = "jdbc:mysql://localhost:3306/";

        try (Connection connection = DriverManager.getConnection(DB_URL, "root", "Nexponka999");
             Statement stmn = connection.createStatement();
        ) {
            //stmn.executeUpdate("CREATE DATABASE clients");
        }
        //RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        //System.out.println(runtimeMXBean.getClassPath());
    }
}
