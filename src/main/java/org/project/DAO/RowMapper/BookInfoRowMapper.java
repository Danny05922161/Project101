package org.project.DAO.RowMapper;

import org.project.DTO.BookInfoDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfoRowMapper implements RowMapper<BookInfoDTO>{

    @Override
    public BookInfoDTO mapRow (ResultSet rs) throws SQLException {
        BookInfoDTO bookInfoDTO = new BookInfoDTO();
        bookInfoDTO.setRank(rs.getInt("rank"));
        bookInfoDTO.setBookName(rs.getString("book_name"));
        bookInfoDTO.setAuthor(rs.getString("author"));
        bookInfoDTO.setPublisher(rs.getString("publisher"));
        bookInfoDTO.setBookCounts(rs.getInt("book_counts"));

        return bookInfoDTO;
    }
}
