package org.project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialTable {

    public static void InitialTable(String dbType) {
        Connection conn = null;
        Statement stmt = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            if(dbType.equals(DatabaseLookUp.DatabaseType.SQL_SERVER)){
                conn = ConnectionUtil.getMSSQLConnection();
                stringBuilder.append("IF EXISTS (SELECT * " +
                        "FROM sys.tables " +
                        "WHERE name = 'book_info' AND type = 'U') " +
                        "DROP TABLE book_info;");
                stringBuilder.append("CREATE TABLE book_info (" +
                        "rank NUMERIC(10,0)," +
                        "book_name VARCHAR(100)," +
                        "author VARCHAR(100)," +
                        "publisher VARCHAR(100)," +
                        "book_counts NUMERIC(10,0))");
            }else {
                conn = ConnectionUtil.getMSSQLConnection();
//                stringBuilder.append("DROP TABLE IF EXISTS `book_info`;\n");
//                stringBuilder.append("CREATE TABLE `book_info` (\n" +
//                        "                    `rank` NUMERIC(10,0),\n" +
//                        "                    `book_name` VARCHAR(100),\n" +
//                        "                    `author` VARCHAR(100),\n" +
//                        "                    `publisher` VARCHAR(100),\n" +
//                        "                    `book_counts` NUMERIC(10,0))");
            }

            stmt = conn.createStatement();
            stmt.executeUpdate(stringBuilder.toString());
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            System.out.println("Create Table Failed!");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown error!");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}