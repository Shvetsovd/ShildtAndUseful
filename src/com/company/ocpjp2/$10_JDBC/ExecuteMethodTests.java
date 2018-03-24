package company.ocpjp2.$10_JDBC;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by user on 22.03.2018.
 */
public class ExecuteMethodTests {
    public static void main(String[] args) throws SQLException {
        //подключиться к БД
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "Nexponka999");
            Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ){
            ResultSet rs;
            boolean isResultSet;
            int count;

            //сделать запрос через executeQuery
            rs = stmnt.executeQuery("SELECT * FROM animal");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }

            //сделать запрос через executeUpdate
            count = stmnt.executeUpdate("INSERT INTO animal values (6, 1, 'Dima', '1985-01-02 11:44')");
            System.out.println("Insert: " + count + " row");

            //сделать запрос через execute
            //SELECT
            isResultSet = stmnt.execute("SELECT * FROM animal WHERE name = 'Dima'");
            if (isResultSet){
                rs = stmnt.getResultSet();
                while (rs.next()){
                    printRow(rs);
                }
                while (rs.previous()){
                    printRow(rs);
                }
            }

            //UPDATE
            isResultSet = stmnt.execute("DELETE FROM animal WHERE name = 'Dima'");
            if (!isResultSet){
                count = stmnt.getUpdateCount();
                System.out.println("Deleted: " + count + " row");
            }

        }

    }

    private static void printRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        LocalDateTime birth = rs.getTimestamp("date_born").toLocalDateTime();

        System.out.println(id + " " + name + " " + birth);
    }
}
