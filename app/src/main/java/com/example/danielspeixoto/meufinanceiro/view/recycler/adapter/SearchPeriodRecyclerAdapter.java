package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.SearchInPeriod;
import com.example.danielspeixoto.meufinanceiro.module.UpdateAmount;
import com.example.danielspeixoto.meufinanceiro.presenter.SearchPeriodPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class SearchPeriodRecyclerAdapter extends TransactionsRecyclerAdapter implements SearchInPeriod.View, UpdateAmount.Presenter {

    private SearchInPeriod.Presenter mPresenter;
    private final UpdateAmount.View mView;

    public SearchPeriodRecyclerAdapter(BaseActivity activity, UpdateAmount.View mView) {
        super(activity);
        this.mView = mView;
        mPresenter = new SearchPeriodPresenter(this);
    }

    //TODO Is that the best option to handle the amount?
    @Override
    public void setAmountOfMoney(double amountOfMoney) {
        mView.onAmountReceived(amountOfMoney);
    }

    @Override
    public void setDates(String startDate, String endDate) {
        mPresenter.search(startDate, endDate);
    }

    @Override
    public void addItem(Transaction transaction) {
        super.addItem(transaction);
    }

    @Override
    public void refreshData() {
        data = mPresenter.getData();
        notifyDataSetChanged();
    }
}
