package peaksoft.dao;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;
import peaksoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
//        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
//                "id SERIAL PRIMARY KEY, " +
//                "name VARCHAR(50) NOT NULL, " +
//                "last_name VARCHAR(50) NOT NULL, " +
//                "age INTEGER DEFAULT 18);";
//
        SessionFactory factory = null;
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            session.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try  {
            User user = new User(name, lastName, age);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :check");
            query.setParameter("check", id).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List list = new ArrayList();
        try  {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
        cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
