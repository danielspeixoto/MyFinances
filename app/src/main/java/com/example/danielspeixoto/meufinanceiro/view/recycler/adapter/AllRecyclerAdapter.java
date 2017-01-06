package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public abstract class AllRecyclerAdapter extends BaseRecyclerAdapter {

    protected CRUD.All.Presenter mSelectAllPresenter;

    public AllRecyclerAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void refreshData() {
        data.clear();
        mSelectAllPresenter.selectAll();
        notifyDataSetChanged();
    }
}
