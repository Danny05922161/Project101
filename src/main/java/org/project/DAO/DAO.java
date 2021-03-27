package org.project.DAO;

import java.util.Map;

public interface DAO{
    void insert(String tableName, Map<String, Object> parameterMap);

    void update(String tableName, Map<String, Object> parameterMap);

    void delete(String tableName, Map<String, Object> parameterMap);

    Object get(String tableName, Map<String, Object> parameterMap);
}
