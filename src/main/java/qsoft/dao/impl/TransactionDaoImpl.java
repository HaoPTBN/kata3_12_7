package qsoft.dao.impl;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import qsoft.dao.TransactionDao;
import qsoft.entity.BankAccount;
import qsoft.entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: haopt
 * Date: 7/10/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDaoImpl extends JpaDaoSupport implements TransactionDao {

    EntityManagerFactory entityManagerFactory;

    public TransactionDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JpaPersistenceUnit", System.getProperties());
        super.setEntityManagerFactory(entityManagerFactory);
    }

    public Transaction save(Transaction transaction) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();

        return null;
    }

    public Transaction getTransactionById(Integer integer) {
        return getJpaTemplate().find(Transaction.class, integer);
    }

    public List<Transaction> findAllByAccountNumber(String accountNumber) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT h FROM Transaction h WHERE h.accountNumber = :accountNumber", Transaction.class);
        query.setParameter("accountNumber", accountNumber);
        List<Transaction> list = query.getResultList();
        return list;
    }

    public List<Transaction> findAllByAccountNumberAndBetweenTime(String accountNumber, Long startTime, Long finishTime) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("select o from Transaction o where o.accountNumber = :qAccountNumber and o.timeStamp >= :qStartTime and o.timeStamp <= :qStopTime", Transaction.class);
        query.setParameter("qAccountNumber", accountNumber);
        query.setParameter("qStartTime", startTime);
        query.setParameter("qStopTime", finishTime);
        List<Transaction> list = query.getResultList();
        return list;
    }
}
