package com.example.danielspeixoto.meufinanceiro.util;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class Repeated {

    public static List<Transaction> generateTransactions(Transaction transaction, int amount, int frequency) {
        ArrayList<Transaction> transactions = new ArrayList<>(amount);
        transactions.add(transaction);
        for (int i = 0; i < amount - 1; i++) {
            Transaction t = new Transaction(transaction);
            t.setExpirationDate(DateString.sumPeriod(transactions.get(i).getExpirationDate(), frequency));
            transactions.add(t);
        }
        return transactions;
    }
}
