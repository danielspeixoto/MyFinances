package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.ButterKnife;
import lombok.Setter;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public abstract class BaseHolder extends RecyclerView.ViewHolder {

    @Setter
    protected int index;
    protected BaseRecyclerAdapter mAdapter;

    public BaseHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView);
        this.mAdapter = mAdapter;
        ButterKnife.bind(this, itemView);
    }

}
