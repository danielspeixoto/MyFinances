package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.presenter.AllTransactionsPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class AllTransactionsRecyclerAdapter extends TransactionsRecyclerAdapter implements CRUD.All.View<Transaction> {

    protected CRUD.All.Presenter mSelectAllPresenter;

    public AllTransactionsRecyclerAdapter(BaseActivity activity) {
        super(activity);
        mSelectAllPresenter = new AllTransactionsPresenter(this);
    }

    @Override
    public void refreshData() {
        data.clear();
        mSelectAllPresenter.selectAll();
        notifyDataSetChanged();
    }
}
