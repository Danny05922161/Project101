package org.project.DAO;

import org.project.ConnectionUtil;
import org.project.DTO.BookInfoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BookInfoMySQLDAOImpl implements BookInfoDAO {

    private Connection connection;


    public BookInfoMySQLDAOImpl(){
        try {
            connection = ConnectionUtil.getMySQLConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<BookInfoDTO> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<BookInfoDTO> getAll() {
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
