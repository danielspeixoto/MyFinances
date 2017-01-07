package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class SearchInPeriod {

    public interface View extends Base.View {

        void addItem(Transaction transaction);

        void setDates(String startDate, String endDate);

        void setAmountOfMoney(double amountOfMoney);

    }

    public interface Presenter extends Base.Presenter {

        void search(String startDate, String endDate);

        ArrayList<Transaction> getData();
    }
}
