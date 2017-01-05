package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.module.IListView;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements IListView {

    @Getter
    protected BaseActivity activity;
    @Getter
    @Setter
    protected ArrayList data = new ArrayList<>();

    public BaseRecyclerAdapter(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void addItem(Object object) {
        data.add(object);
        activity.runOnUiThread(() -> notifyDataSetChanged());
    }

    public abstract void refreshData();

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected void showMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
