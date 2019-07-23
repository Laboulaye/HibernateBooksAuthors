package dao;

import table.BookAuthors;

import java.sql.SQLException;
import java.util.List;

public interface BookAuthorDao {

    void addBookAuthor(BookAuthors bookAuthors) throws SQLException;
    List<BookAuthors> getBookAuthors() throws SQLException;
}
