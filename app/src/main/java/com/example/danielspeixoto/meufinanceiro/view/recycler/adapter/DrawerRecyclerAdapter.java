package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.holder.DrawerHolder;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerRecyclerAdapter extends BaseRecyclerAdapter {

    public DrawerRecyclerAdapter(BaseActivity activity) {
        super(activity);
        addItem("Create new Institution");
        addItem("Search in a period");
        addItem("Payed");
    }

    @Override
    public void getItems() {
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String item = (String) data.get(position);
        DrawerHolder itemHolder = (DrawerHolder) holder;
        itemHolder.setIndex(position);
        itemHolder.getDrawerText().setText(item);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrawerHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_drawer_item, parent, false),
                this);
    }

}
