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
/*

        Author author1 = new Author("G.", "Shildt");
        Author author2 = new Author("K.", "Hortsman");
        Author author3 = new Author("K.", "Sierra");
        Author author4 = new Author("B.", "Ekkel");
        authorDao.addAuthor(author1);
        authorDao.addAuthor(author2);
        authorDao.addAuthor(author3);
        authorDao.addAuthor(author4);
        System.out.println("Авторы добавлены");
*/

       /*authorDao.deleteAuthor(authorDao.getAuthor(1));
        authorDao.deleteAuthor(authorDao.getAuthor(2));
        authorDao.deleteAuthor(authorDao.getAuthor(3));
        authorDao.deleteAuthor(authorDao.getAuthor(4));*/

       /* List<Author> authors = authorDao.getAuthors();
        System.out.println("List of authors: ");
        System.out.println("id  first_name  last_name");
        for (Author author : authors) {
            System.out.println(author.getId() + "   " + author.getFirstName() + "          " + author.getLastName());
        }*/

        /*//проверяем как работает метод addBook()
        Book kniga1 = new Book("Java Tutorial", "Description language", 325);
        Book kniga2 = new Book("SQL Tutorial", "Description SQL quories", 375);
        Book kniga3 = new Book("Python Tutorial", "Desc language Python", 546);
        Book kniga4 = new Book("C++ Tutorial", "Desc C++ language", 782);
        bookDao.addBook(kniga1);
        bookDao.addBook(kniga2);
        bookDao.addBook(kniga3);
        bookDao.addBook(kniga4);
        System.out.println("Книги добавлены");

        //проверяем как работает метод getBooks
        List<Book> books = bookDao.getBooks();
        System.out.println("List of books: ");
        System.out.println("id  isbn    title   description");
        for (Book book : books){
            System.out.println(book.getId() + " " + book.getIsbn() + "  " + book.getTitle()
                    + " " + book.getDescription());
        }*/

       /* //проверяем как работает метод deleteBook() и getBook()
        bookDao.deleteBook(bookDao.getBook(6));
        bookDao.deleteBook(bookDao.getBook(7));
        bookDao.deleteBook(bookDao.getBook(9));
        bookDao.deleteBook(bookDao.getBook(10));
        bookDao.deleteBook(bookDao.getBook(11));*/

       /*//проверяем как работает метод getBooks
        List<Book> booksFinal = bookDao.getBooks();
        System.out.println("Final list of books: ");
        System.out.println("id  isbn    title           description");
        for (Book kniga : booksFinal){
            System.out.println(kniga.getId() + "    " + kniga.getIsbn() + " " + kniga.getTitle()
                                        + "         " + kniga.getDescription());
        }
*/
       /* Book kniga1 = new Book("Java Tutorial", "Description language", 325);
        Book kniga2 = new Book("SQL Tutorial", "Description SQL quories", 375);
        Book kniga3 = new Book("Python Tutorial", "Desc language Python", 546);
        Book kniga4 = new Book("C++ Tutorial", "Desc C++ language", 782);
        Author author1 = new Author("G.", "Shildt");
        Author author2 = new Author("K.", "Hortsman");
        BookAuthors bookAuthor1 = new BookAuthors(kniga1, author2);
        BookAuthors bookAuthor2 = new BookAuthors(kniga3, author2);
        BookAuthors bookAuthor3 = new BookAuthors(kniga2, author1);
        BookAuthors bookAuthor4 = new BookAuthors(kniga4, author1);

        bookAuthorDao.addBookAuthor(bookAuthor1);
        bookAuthorDao.addBookAuthor(bookAuthor2);
        bookAuthorDao.addBookAuthor(bookAuthor3);
        bookAuthorDao.addBookAuthor(bookAuthor4);*/

        List<BookAuthors> bookAuthors = bookAuthorDao.getBookAuthors();
        System.out.println("Books and Authors");
        System.out.println("book_id  isbn    title         description       author_id     " +
                                "first_name    last_name");
        for(BookAuthors bookAuthor : bookAuthors){
            Book book = bookAuthor.getBook();
            Author author = bookAuthor.getAuthor();
            System.out.print(book.getId() + "       " + book.getIsbn() + "       " + book.getTitle()
                    + "      " + book.getDescription());

            System.out.println("        " + author.getId() + "   " + author.getFirstName() + "         "
                                    + author.getLastName());
        }
    }
}
