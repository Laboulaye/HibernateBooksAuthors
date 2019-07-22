package general;

import dao.BookDao;
import table.Book;

import java.sql.SQLException;
import java.util.List;

public class Project {

    public static void main(String[] args) throws SQLException {
        Factory factory = Factory.getInstance();
        BookDao bookDao = factory.getBookDao();

        //проверяем как работает метод addBook()
        Book kniga1 = new Book("Java Tutorial", "Description language", 325);
        Book kniga2 = new Book("SQL Tutorial", "Description SQL quories", 375);
        bookDao.addBook(kniga1);
        bookDao.addBook(kniga2);
        System.out.println("Книги добавлены");

        //проверяем как работает метод getBooks
        List<Book> books = bookDao.getBooks();
        System.out.println("List of books: ");
        System.out.println("id  isbn    title   description");
        for (Book book : books){
            System.out.println(book.getId() + " " + book.getIsbn() + "  " + book.getTitle()
                    + " " + book.getDescription());
        }

        //проверяем как работает метод deleteBook() и getBook()
       Book removeBook = bookDao.getBook(8);
        bookDao.deleteBook(removeBook);

       //проверяем как работает метод getBooks
        List<Book> booksFinal = bookDao.getBooks();
        System.out.println("Final list of books: ");
        System.out.println("id  isbn    title   description");
        for (Book kniga : booksFinal){
            System.out.println(kniga.getId() + " " + kniga.getIsbn() + "  " + kniga.getTitle()
                                        + " " + kniga.getDescription());
        }
    }
}
