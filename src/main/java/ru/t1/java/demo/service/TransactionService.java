package ru.t1.java.demo.service;


import ru.t1.java.demo.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> registerTransactions(List<Transaction> Transactions);

    Transaction registerTransaction(Transaction transaction);


}
