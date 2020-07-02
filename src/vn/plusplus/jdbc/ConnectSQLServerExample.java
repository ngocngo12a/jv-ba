package vn.plusplus.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class ConnectSQLServerExample {

    public static void main(String args[]) {
        try {
            Connection conn = getConnection( "jdbc:mysql://localhost:3306/student_cms_plusplus", "root", "ngochoatuyen");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from class where total_student >=4000   ");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
