package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.view.View;

import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import lombok.Setter;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public abstract class ItemHolder extends BaseHolder {

    @Setter
    protected String id;

    public ItemHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }
}
