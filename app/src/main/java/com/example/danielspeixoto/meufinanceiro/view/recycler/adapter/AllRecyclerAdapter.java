package com.example.danielspeixoto.meufinanceiro.view.recycler.adapter;

import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectAllPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public abstract class AllRecyclerAdapter extends BaseRecyclerAdapter {

    protected ISelectAllPresenter mSelectAllPresenter;

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
