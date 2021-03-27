package org.project.DAO;

import org.project.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class MySQLDAOImpl implements DAO{

    private Connection connection;

    public MySQLDAOImpl(){
        try {
            connection = ConnectionUtil.getMySQLConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String tableName, Map<String, Object> parameterMap) {

    }

    @Override
    public void update(String tableName, Map<String, Object> parameterMap) {

    }

    @Override
    public void delete(String tableName, Map<String, Object> parameterMap) {

    }

    @Override
    public Object get(String tableName, Map<String, Object> parameterMap) {
        return null;
    }
}
