package dev.shailendra.repositories.hibernate;

import com.sun.xml.internal.ws.handler.HandlerException;
import dev.shailendra.models.User;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserHibernate implements UserRepo {
    @Override
    public User add(User user) {
        Transaction tx = null;
        try(Session s = HibernateUtil.getSession()){
            tx = s.beginTransaction();
            s.save(user);
            tx.commit();
        } catch (HandlerException e){
            e.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
        return user;
    }

    @Override
    public User getById(Integer id) {
        Session s = HibernateUtil.getSession();
        User u = s.get(User.class, id);
        s.close();
        return u;
    }

    @Override
    public User getByEmail(String email) {
          User u = null;
          try(Session s = HibernateUtil.getSession()){
              CriteriaBuilder cb = s.getCriteriaBuilder();
              CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
              Root<User> root = criteriaQuery.from(User.class);
              Predicate p = cb.equal(root.get("email"), email);
              criteriaQuery.select(root).where(p);
              u = s.createQuery(criteriaQuery).getSingleResult();
          }catch (HibernateException e){
              e.printStackTrace();
          }
        return u;
    }

    @Override
    public List<User> getAll() {
        Session s = HibernateUtil.getSession();
        //Create a query object
        String query = "from User"; //this is HQL (Not Native SQL)
        Query<User> q = s.createQuery(query, User.class);
        List<User> user = q.getResultList();
        s.close();
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
