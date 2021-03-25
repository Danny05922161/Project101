package org.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

    //連線資訊
    private static String MSSQLurl = "jdbc:sqlserver://localhost:1433;databaseName=labs";
    private static String MySQLurl = "jdbc:mysql://localhost:3306/sys"
            + "?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";

    private static String user = "SA";
    private static String password = "Abc12345";

    public static Connection getMSSQLConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(MSSQLurl, user, password);
        System.out.println("connection successful");
        return conn;
    }

    public static Connection getMySQLConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(MySQLurl, user, password);
        System.out.println("connection successful");
        return conn;
    }


}
