package org.project;

import java.sql.*;

public class CreateTable {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionUtil.getMSSQLConnection();
            stmt = conn.createStatement();

            String sql = "CREATE TABLE book_info " +
                    "(rank NUMERIC(10,0), " +
                    " book_name VARCHAR(100), " +
                    " author VARCHAR(100), " +
                    " publisher VARCHAR(100), " +
                    " book_counts NUMERIC(10,0) )";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
