package company.ocpjp2.$10_JDBC;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by user on 22.03.2018.
 */
public class ResultSetReadingTest {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "Nexponka999");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM animal")){

            while (rs.next()){
                int id = rs.getInt("id"); // or "ID" is ok - no case sensetive
                String name = rs.getString("name");

                LocalDateTime birth = rs.getTimestamp("date_born").toLocalDateTime();
                LocalDate date = rs.getDate("date_born").toLocalDate();
                LocalTime time = rs.getTime("date_born").toLocalTime();

                //String s = rs.getString("no_such_field"); //throw SQLException

                System.out.println(id + " " + name + " " + birth + " " + date + " " + time);
            }
        }
    }
}

class ResultSetReadingTest2 {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "Nexponka999");
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM animal")){

            while (rs.next()){
                //int id = rs.getInt(0); //throws SQLException - field numeration from 1
                int id = rs.getInt(1);
                String name = rs.getString(3);
                LocalDateTime birth = rs.getTimestamp(4).toLocalDateTime();

                System.out.println(id + " " + name + " " + birth);
            }
        }
    }
}

class ResultSetReadingTest3 {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "Nexponka999");
            Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //or TYPE_SCROLL_SENSITIVE!
            ResultSet rs = stmnt.executeQuery("SELECT * FROM animal")){

            rs.afterLast(); //return void!

            while (rs.previous()){
                printRow(rs);
            }

            if (rs.relative(2)) printRow(rs); //forward
            if (rs.relative(-1)) printRow(rs); //bacward
            if (rs.absolute(1)) printRow(rs); //first row
            if (rs.first()) printRow(rs); //first row
            if (rs.absolute(-1)) printRow(rs); //last row
            if (rs.last()) printRow(rs); //first row

            rs.beforeFirst(); //return void!
            while (rs.next()){
                printRow(rs);
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

