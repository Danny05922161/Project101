package org.project.DAO;

import org.project.DTO.BookInfoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookInfoDAO{

    public Optional<BookInfoDTO> get(long id);

    public List<BookInfoDTO> getAll();

    public void save(BookInfoDTO bookInfoDTO);

    public void update(BookInfoDTO bookInfoDTO);

    public void delete(BookInfoDTO bookInfoDTO);
}
