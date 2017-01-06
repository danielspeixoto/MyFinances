package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.AllTransactionsPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.holder.TransactionHolder;

import java.util.Collections;

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
        TransactionHolder transactionHolder = (TransactionHolder) holder;
        transactionHolder.setTransaction((Transaction) data.get(position));
        transactionHolder.onPostCreated();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TransactionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_transaction_item, parent, false), this);
    }

    @Override
    public void addItem(Object object) {
        data.add(object);
        Collections.sort(data);
        notifyDataSetChanged();
    }
}
