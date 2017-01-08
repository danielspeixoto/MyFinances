package com.example.danielspeixoto.meufinanceiro.util;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class Validate {

    public static final String SUCCESS = "SUCCESS";

    public static String transaction(Transaction transaction) {
        if(transaction.getAmount() < 0) {
            return "The amount must have a value bigger than 0";
        }
        return SUCCESS;
    }

    public static String institution(Institution institution) {
        if(institution.getName().isEmpty()) {
            return "Can't be empty";
        }
        return SUCCESS;
    }
}
