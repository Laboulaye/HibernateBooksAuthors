package dao.impl;

import dao.BookAuthorDao;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import table.BookAuthors;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDaoImpl implements BookAuthorDao {

    @Override
    public void addBookAuthor(BookAuthors bookAuthors) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(bookAuthors);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<BookAuthors> getBookAuthors() {
        List<BookAuthors> bookAuthors = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            bookAuthors = session.createCriteria(BookAuthors.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bookAuthors;
    }
}
