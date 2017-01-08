package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import com.example.danielspeixoto.meufinanceiro.module.TransactionSource;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

import lombok.Setter;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class SourceRecyclerAdapter extends TransactionsRecyclerAdapter implements TransactionSource.View {

    @Setter
    private TransactionSource.Presenter presenter;

    public SourceRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void getItems() {
        presenter.selectAll();
        notifyDataSetChanged();
    }
}
