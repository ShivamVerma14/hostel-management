package utils;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASSWORD = "test";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
