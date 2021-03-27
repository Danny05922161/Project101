package org.project.DAO;

import org.project.DAO.RowMapper.RowMapper;

import java.util.List;
import java.util.Map;

public interface DAO{
    void insert(String tableName, Map<String, Object> parameterMap);

    void update(String tableName, Map<String, Object> parameterMap);

    void delete(String tableName, Map<String, Object> parameterMap);

    List<Object> get(String tableName, Map<String, Object> parameterMap, RowMapper rowMapper);
}
