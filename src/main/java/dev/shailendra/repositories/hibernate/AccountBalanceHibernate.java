package dev.shailendra.repositories.hibernate;

import dev.shailendra.models.AccountBalance;
import dev.shailendra.models.Application;
import dev.shailendra.repositories.AccountBalanceRepo;
import dev.shailendra.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class AccountBalanceHibernate implements AccountBalanceRepo {
    @Override
    public AccountBalance add(AccountBalance accountBalance) {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.save(accountBalance);
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
    public AccountBalance getById(Integer id) {
        Session s = HibernateUtil.getSession();
        String query = "from AccountBalance where id = :id";
        Query<AccountBalance> q = s.createQuery(query, AccountBalance.class);
        q.setParameter("id", id);

        AccountBalance ab;
        try{
            ab = q.getSingleResult();
            System.out.println("Getting Account Details by ID" + ab);
        }catch (NoResultException nre){
            nre.printStackTrace();
            s.close();
            return null;
        }
        s.close();
        return ab;
    }

    @Override
    public List<AccountBalance> getAll() {
        // Let's use the Query Interface
        Session s = HibernateUtil.getSession();

        // Create a query object
        String query = "from AccountBalance"; // this is HQL (NOT native sql -> select * from authors
        Query<AccountBalance> q = s.createQuery(query, AccountBalance.class);

        List<AccountBalance> accountBalanceList = q.getResultList();

        s.close();

        return accountBalanceList;
    }

    @Override
    public void update(AccountBalance accountBalance) {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            s.update(accountBalance);
            tx.commit();
        } catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            s.close();
        }
    }

    @Override
    public void delete(Integer id) {
        Session s = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = s.beginTransaction();
            s.delete(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            s.close();
        }
    }
    }

