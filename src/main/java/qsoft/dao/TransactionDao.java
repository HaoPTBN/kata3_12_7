package qsoft.dao;

import qsoft.entity.BankAccount;
import qsoft.entity.Transaction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: haopt
 * Date: 7/10/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TransactionDao {

    public Transaction save(Transaction transaction);

    public Transaction getTransactionById(Integer integer);

    public List<Transaction> findAllByAccountNumber(String accountNumber);

    public List<Transaction> findAllByAccountNumberAndBetweenTime(String accountNumber,Long startTime, Long finishTime);
}
