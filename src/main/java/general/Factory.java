package general;

import dao.BookDao;
import dao.impl.BookDaoImpl;

public class Factory {

    public static Factory instance = new Factory();
    public BookDao bookDao;

    private Factory(){}

    public static Factory getInstance(){
        return Factory.instance;
    }

    public BookDao getBookDao(){
        if(bookDao == null){
            bookDao = new BookDaoImpl();
        }
        return bookDao;
    }
}
