package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.AllTransactionsPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.holder.TransactionHolder;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class TransactionRecyclerAdapter extends AllRecyclerAdapter {

    public TransactionRecyclerAdapter(BaseActivity activity) {
        super(activity);
        mSelectAllPresenter = new AllTransactionsPresenter(this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Transaction transaction = (Transaction) data.get(position);
        TransactionHolder transactionHolder = (TransactionHolder) holder;
        transactionHolder.setId(transaction.getId());
        transactionHolder.setIndex(position);
        transactionHolder.getAmountText().setText("$" + transaction.getAmount());
        transactionHolder.getNameText().setText(transaction.getName());
        transactionHolder.getExpirationText().setText(transaction.getExpirationDate());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TransactionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_transaction_item, parent, false), this);
    }

    @Override
    public void onError(String message) {

    }
}
