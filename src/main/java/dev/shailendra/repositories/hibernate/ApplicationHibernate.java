package dev.shailendra.repositories.hibernate;

import dev.shailendra.models.Application;
import dev.shailendra.repositories.ApplicationRepo;
import dev.shailendra.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class ApplicationHibernate implements ApplicationRepo {
    @Override
    public Application add(Application application) {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.save(application);
            tx.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            if(tx !=null){
                tx.rollback();
            }
        }finally {
            s.close();
        }
        return null;
    }

    @Override
    public Application getById(Integer id) {
        Application a;
        try(Session s = HibernateUtil.getSession()){
            String query = "from Application where id = :id";
            Query<Application> applicationQuery = s.createQuery(query, Application.class);
            applicationQuery.setParameter("id", id);
            a = applicationQuery.getSingleResult();
            System.out.println("Getting application by Id" + a);
        }catch (NoResultException nre){
            nre.printStackTrace();
            return null;
        }
        return a;
    }

    @Override
    public List<Application> getAll() {
        // Let's use the Query Interface
        Session s = HibernateUtil.getSession();

        // Create a query object
        String query = "from Application"; // this is HQL (NOT native sql -> select * from authors
        Query<Application> q = s.createQuery(query, Application.class);

        List<Application> applications = q.getResultList();

        s.close();

        return applications;
    }

    @Override
    public void update(Application application) {
        Transaction tx = null;
        try(Session s = HibernateUtil.getSession()){
            tx = s.beginTransaction();
            s.update(application);
            tx.commit();
        }catch(HibernateException e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Transaction tx = null;

        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            s.delete(id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        }
    }
}
