package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory(){
        SessionFactory factory = null;
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }
}
