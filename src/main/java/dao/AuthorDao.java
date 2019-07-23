package dao;

import table.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {
    void addAuthor(Author author) throws SQLException;
    void deleteAuthor(Author author) throws SQLException;
    Author getAuthor(int id) throws SQLException;
    List<Author> getAuthors() throws SQLException;
}
