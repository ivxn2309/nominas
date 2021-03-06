package nominas.util;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Object saveObject(Object object){
        Session session = sessionFactory.openSession();
        Object objectId = 0;
        try {            
            session.beginTransaction();
            objectId = session.save(object);
            session.getTransaction().commit();
        }
        catch (HibernateException he) {
            System.err.println(he.getMessage());
        }
        finally {
            session.close();
        }        
        return objectId;
    }
    
    public static void updateObject(Object object){
        Session session = sessionFactory.openSession();
        try {            
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
        }
        catch (HibernateException he) {
            System.err.println(he.getMessage());
        }
        finally {
            session.close();
        }
    }
    
    public static void removeObject(Object object){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } 
        catch (HibernateException he) {
            System.err.println(he.getMessage());
        }
        finally {
            session.close();
        }
    }
    
    public static List executeHQLQuery(String hql) {
        List result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            result = query.list();
            session.getTransaction().commit();
            
        } 
        catch (HibernateException he) {
            System.err.println(he.getMessage());
        }
        finally {
            session.close();
        }
        return result;
    }
    
    public static int executeHQLUpdateQuery(String hql) {
        int result = -1;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery(hql);
            result = query.executeUpdate();
        } 
        catch (HibernateException he) {
            System.err.println(he.getMessage());
        }
        finally {
            session.close();
        }
        return result;
    }
}
