package org.project.Repo;

import org.project.DAO.DAO;

public interface Repository<T> {
    void setDAO(DAO dao);
    void insert(T t);
    void update(T t);
    T findByCondition(T t);
    void delete(T t);
}