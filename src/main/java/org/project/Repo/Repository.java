package org.project.Repo;

import org.project.DAO.DAO;

import java.util.List;

public interface Repository<T> {
    void setDAO(DAO dao);
    void insert(T t);
    void update(T t);
    List<T> findByCondition(T t);
    void delete(T t);
}