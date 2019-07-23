package general;

import dao.AuthorDao;
import dao.BookAuthorDao;
import dao.BookDao;
import table.Author;
import table.Book;
import table.BookAuthors;

import java.sql.SQLException;
import java.util.List;

public class Project {

    public static void main(String[] args) throws SQLException {
        Factory factory = Factory.getInstance();
        BookDao bookDao = factory.getBookDao();
        AuthorDao authorDao = factory.getAuthorDao();
        BookAuthorDao bookAuthorDao = factory.getBookAuthorDao();

        //Заполняем таблицу Author 2 авторами
        Author author1 = new Author("G.", "Shildt");
        Author author2 = new Author("K.", "Hortsman");

        authorDao.addAuthor(author1);
        authorDao.addAuthor(author2);

        //Выводим таблицу Author на экран
        List<Author> authors = authorDao.getAuthors();
        System.out.println("TABLE AUTHORS: ");
        System.out.println("id  first_name  last_name");
        for (Author author : authors) {
            System.out.println(author.getId() + "   " + author.getFirstName() + "   " + author.getLastName());
        }

        //Заполняем таблицу Book 4-мя книгами
        Book kniga1 = new Book("Java Tutorial", "Description language", 325);
        Book kniga2 = new Book("SQL Tutorial", "Description SQL quories", 375);
        Book kniga3 = new Book("Python Tutorial", "Desc language Python", 546);
        Book kniga4 = new Book("C++ Tutorial", "Desc C++ language", 782);

        bookDao.addBook(kniga1);
        bookDao.addBook(kniga2);
        bookDao.addBook(kniga3);
        bookDao.addBook(kniga4);

        //Выводим таблицу BOOK на экран
        List<Book> books = bookDao.getBooks();
        System.out.println("TABLE BOOKS: ");
        System.out.println("id  isbn    title   description");
        for (Book book : books){
            System.out.println(book.getId() + " " + book.getIsbn() + "  " + book.getTitle()
                    + " " + book.getDescription());
        }


       //Зполняем таблицу BookAuthors  соединением значений из двух предыдущих таблиц
        BookAuthors bookAuthor1 = new BookAuthors(kniga1, author2);
        BookAuthors bookAuthor2 = new BookAuthors(kniga3, author2);
        BookAuthors bookAuthor3 = new BookAuthors(kniga2, author1);
        BookAuthors bookAuthor4 = new BookAuthors(kniga4, author1);

        bookAuthorDao.addBookAuthor(bookAuthor1);
        bookAuthorDao.addBookAuthor(bookAuthor2);
        bookAuthorDao.addBookAuthor(bookAuthor3);
        bookAuthorDao.addBookAuthor(bookAuthor4);

        //Выводи таблицу BookAuthors на экран
        List<BookAuthors> bookAuthors = bookAuthorDao.getBookAuthors();
        System.out.println("TABLE BOOK_AUTHORS");
        System.out.println("book_id isbn    title   description author_id   " +
                                "first_name last_name");
        for(BookAuthors bookAuthor : bookAuthors){
            Book book = bookAuthor.getBook();
            Author author = bookAuthor.getAuthor();
            System.out.print(book.getId() + "   " + book.getIsbn() + "  " + book.getTitle()
                    + " " + book.getDescription());

            System.out.println("    " + author.getId() + "  " + author.getFirstName() + "   "
                                    + author.getLastName());
        }
    }
}
