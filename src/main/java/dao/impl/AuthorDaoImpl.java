package dao.impl;

import dao.AuthorDao;
import org.hibernate.Session;
import table.Author;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    @Override
    public void addAuthor(Author author){

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.save(author);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Author author) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public Author getAuthor(int id){
        Author result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            result = session.get(Author.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Author> getAuthors() {
        List<Author> authors = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            authors = session.createCriteria(Author.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return authors;
    }
}
