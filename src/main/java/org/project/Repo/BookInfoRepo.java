package org.project.Repo;

import org.project.DAO.DAO;
import org.project.DAO.RowMapper.BookInfoRowMapper;
import org.project.DTO.BookInfoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookInfoRepo implements Repository<BookInfoDTO> {

    private DAO dao;
    private final String tableName ="book_info";
    @Override
    public void setDAO(DAO dao) {
        this.dao=dao;
    }

    @Override
    public void insert(BookInfoDTO bookInfoDTO) {
        Map<String, Object> map = new HashMap();
        map.put("rank", bookInfoDTO.getRank());
        map.put("author", bookInfoDTO.getAuthor());
        map.put("book_name", bookInfoDTO.getBookName());
        map.put("publisher", bookInfoDTO.getPublisher());
        map.put("book_counts", bookInfoDTO.getBookCounts());

        dao.insert(tableName, map);
    }

    @Override
    public void update(BookInfoDTO bookInfoDTO) {
        Map<String, Object> map = new HashMap();
        map.put("rank", bookInfoDTO.getRank());
        map.put("author", bookInfoDTO.getAuthor());
        map.put("book_name", bookInfoDTO.getBookName());
        map.put("publisher", bookInfoDTO.getPublisher());
        map.put("book_counts", bookInfoDTO.getBookCounts());
        dao.update(tableName, map);
    }

    @Override
    public List<BookInfoDTO> findByCondition(BookInfoDTO bookInfoDTO) {
        Map<String, Object> map = new HashMap();
        if (Objects.nonNull(bookInfoDTO.getAuthor()))
            map.put("author", bookInfoDTO.getAuthor());
        if (Objects.nonNull(bookInfoDTO.getRank()))
            map.put("rank", bookInfoDTO.getRank());
        if (Objects.nonNull(bookInfoDTO.getBookName()))
            map.put("book_name", bookInfoDTO.getBookName());
        if (Objects.nonNull(bookInfoDTO.getPublisher()))
            map.put("publisher", bookInfoDTO.getPublisher());
        if (Objects.nonNull(bookInfoDTO.getBookCounts()))
            map.put("book_counts", bookInfoDTO.getBookCounts());

        return (List<BookInfoDTO>)(List<?>) dao.get(tableName, map, new BookInfoRowMapper());
    }

    @Override
    public void delete(BookInfoDTO bookInfoDTO) {
        Map<String, Object> map = new HashMap();
        map.put("book_name", bookInfoDTO.getBookName());
        map.put("author",bookInfoDTO.getAuthor());
        map.put("publisher", bookInfoDTO.getPublisher());

        dao.delete(tableName, map);
    }
}
