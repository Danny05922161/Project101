package org.project.Factory;

import org.project.DAO.DAO;
import org.project.DAO.MsSQLDAOImpl;
import org.project.DAO.MySQLDAOImpl;
import org.project.DatabaseLookUp;
import org.project.Repo.BookInfoRepo;
import org.project.Repo.Repository;

public class RepoFactory {

    public RepoFactory() {
    }

    public Repository getRepoInstance(String daoType, String tableType) {

        DAO dao;
        switch(daoType) {
            case DatabaseLookUp.DatabaseType.MYSQL:
                dao = new MySQLDAOImpl();
                break;
            case DatabaseLookUp.DatabaseType.SQL_SERVER:
                dao = new MsSQLDAOImpl();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + daoType);
        }

        Repository repo;
        switch(tableType) {
            case DatabaseLookUp.TableName.BOOK_INFO:
                repo = new BookInfoRepo();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tableType);
        }

        repo.setDAO(dao);
        return repo;
    }
}
