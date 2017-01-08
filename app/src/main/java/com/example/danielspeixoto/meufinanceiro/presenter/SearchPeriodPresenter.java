package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDTransactions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.SearchInPeriod;
import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.util.DateString;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class SearchPeriodPresenter implements SearchInPeriod.Presenter {

    private final SearchInPeriod.View mView;
    private CRUDTransactions mCRUD;
    private ArrayList<Transaction> mItems = new ArrayList<>();

    public SearchPeriodPresenter(SearchInPeriod.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDTransactions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void search(String startDate, String endDate) {
        mItems.clear();
        mCRUD.selectAll().subscribe(new Subscriber<Transaction>() {

            String expirationDate;
            double amount = 0;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.getActivity().showMessage("An error occurred");
            }

            @Override
            public void onNext(Transaction transaction) {
                expirationDate = transaction.getExpirationDate();
                if(DateString.compareDates(expirationDate, startDate) >= 0 &&
                        DateString.compareDates(expirationDate, endDate) <= 0) {
                    mView.addItem(transaction);
                    mItems.add(transaction);
                    amount += transaction.isDebt() ? transaction.getAmount() * -1 : transaction.getAmount() ;
                    mView.setAmountOfMoney(amount);
                }
            }
        });
    }

    @Override
    public ArrayList<Transaction> getData() {
        return mItems;
    }
}
