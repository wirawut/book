package ch03.controller;

import ch03.model.Book;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
public class BookManager {

    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println(e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public List list() {
        Session session = factory.openSession();
        session.beginTransaction();
        List books = session.createQuery("FROM Book").list();
        session.getTransaction().commit();
        return books;
    }
}