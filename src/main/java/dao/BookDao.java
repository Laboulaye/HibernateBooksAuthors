package dao;

import table.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    void addBook(Book book) throws SQLException;
    void deleteBook(Book book) throws SQLException;
    Book getBook(int id) throws SQLException;
    List<Book> getBooks() throws SQLException;
}
