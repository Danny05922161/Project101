package org.project.DAO;

import org.project.ConnectionUtil;
import org.project.DAO.RowMapper.RowMapper;
import org.project.DTO.BookInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MsSQLDAOImpl implements DAO {

    private static Connection connection;
    private PreparedStatement pstmt;

    public MsSQLDAOImpl() {
        try {
            connection = ConnectionUtil.getMSSQLConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insert(String tableName, Map<String, Object> parameterMap) {
        List<Object> paramList = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO ")
                .append(tableName)
                .append("(");

        for (String key : parameterMap.keySet()) {
            sqlBuilder.append(key).append(",");
            paramList.add(parameterMap.get(key));
        }
        sqlBuilder.deleteCharAt(sqlBuilder.length() - 1)
                .append(") VALUES(");

        for (int i = 0; i < paramList.size(); i++) {
            sqlBuilder.append("?");
            if (i != parameterMap.size() - 1)
                sqlBuilder.append(",");
        }
        sqlBuilder.append(")");

        try {
            pstmt = connection.prepareStatement(sqlBuilder.toString());
            setParameter(pstmt, paramList);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String tableName, Map<String, Object> parameterMap) {

    }

    @Override
    public void delete(String tableName, Map<String, Object> parameterMap) {

    }

    @Override
    public List<Object> get(String tableName, Map<String, Object> parameterMap, RowMapper rowMapper) {
        List<Object> result = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT * FROM ")
                .append(tableName);
        int index=0;

        if(parameterMap.size()>0){
            sqlBuilder.append(" WHERE ");

            for (String key : parameterMap.keySet()) {
                sqlBuilder.append(key)
                        .append("=")
                        .append(parameterMap.get(key));
                if(index!= parameterMap.size()-1)
                    sqlBuilder.append(" AND ");
                index++;
            }
        }

        try {
            pstmt = connection.prepareStatement(sqlBuilder.toString());
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()){
                result.add(rowMapper.mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void setParameter(PreparedStatement pstmt, List<Object> paramList) throws SQLException {
        int index = 1;
        for (Object param : paramList) {
            if (param instanceof Integer) {
                pstmt.setInt(index, (Integer) param);
            } else if (param instanceof Float) {
                pstmt.setFloat(index, (Float) param);
            } else if (param instanceof Double) {
                pstmt.setDouble(index, (Double) param);
            } else if (param instanceof String) {
                pstmt.setString(index, (String) param);
            } else {
                pstmt.setObject(index, param);
            }
            index++;
        }
    }
}
