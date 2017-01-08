package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.InstitutionSource;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

import java.util.Collections;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class InstitutionsRecyclerAdapter extends BaseRecyclerAdapter<Institution> implements InstitutionSource.View {

    InstitutionSource.Presenter mPresenter;

    public InstitutionsRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void addItem(Institution institution) {
        data.add(institution);
        Collections.sort(data);
        notifyDataSetChanged();
    }

    @Override
    public void getItems() {
        mPresenter.selectAll();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}
