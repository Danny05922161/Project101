package org.project.DAO;

import org.project.ConnectionUtil;
import org.project.DTO.BookInfoDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookInfoMSSQLDAOImpl implements BookInfoDAO {

    private static String MSSQLurl="jdbc:sqlserver://localhost:1433;databaseName=labs";
    private static String user="SA";
    private static String password="Abc12345";

    private Connection connection;


    public BookInfoMSSQLDAOImpl(){
        try {
            connection = ConnectionUtil.getMSSQLConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public Optional<BookInfoDTO> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<BookInfoDTO> getAll(){
        return null;
    }

    @Override
    public void save(BookInfoDTO bookInfoDTO) {

    }

    @Override
    public void update(BookInfoDTO bookInfoDTO) {

    }

    @Override
    public void delete(BookInfoDTO bookInfoDTO) {

    }


}
