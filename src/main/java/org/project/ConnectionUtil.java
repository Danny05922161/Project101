package org.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class ConnectionUtil {

    //連線資訊
    private static Properties prop;

    public static Connection getMSSQLConnection() throws SQLException{
        if(Objects.isNull(prop)){
            getPropertySetting();
        }

        Connection conn = DriverManager.getConnection(
                prop.getProperty("MsSQLUrl"),
                prop.getProperty("MsSQLUser"),
                prop.getProperty("MsSQLPasswd"));

        System.out.println("Connection to SQL server successful!");
        return conn;
    }

    public static Connection getMySQLConnection() throws SQLException{
        if(Objects.isNull(prop)){
            getPropertySetting();
        }

        Connection conn = DriverManager.getConnection(
                prop.getProperty("MySQLUrl"),
                prop.getProperty("MySQLUser"),
                prop.getProperty("MySQLPassword"));

        System.out.println("Connection MySQL successful!");
        return conn;
    }

    //Read Properties
    private static void getPropertySetting(){
        prop = new Properties();
        String propFileName = "datasource.properties";
        InputStream inputStream = null;
        try {
            inputStream = ConnectionUtil.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        }catch (FileNotFoundException e){
            System.out.println("Properties not found!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Close file streaming failed!");
                e.printStackTrace();
            }
        }
    }
}
