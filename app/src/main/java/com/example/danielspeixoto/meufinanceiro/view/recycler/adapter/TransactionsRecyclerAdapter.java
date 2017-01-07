package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.TogglePayedPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.holder.TransactionHolder;

import java.util.Collections;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public abstract class TransactionsRecyclerAdapter extends BaseRecyclerAdapter<Transaction> implements com.example.danielspeixoto.meufinanceiro.module.TogglePayed.View {

    TransactionsRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TransactionHolder transactionHolder = (TransactionHolder) holder;
        transactionHolder.setTransaction(data.get(position));
        transactionHolder.onPostCreated();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TransactionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_transaction_item, parent, false), this);
    }

    @Override
    public void addItem(Transaction transaction) {
        data.add(transaction);
        Collections.sort(data);
        notifyDataSetChanged();
    }

    public void togglePayed(int position) {
        new TogglePayedPresenter(this).toggle(data.get(position));
        data.remove(position);
        notifyItemRemoved(position);
    }

}