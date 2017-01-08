package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.helper.SwipeHelper;
import com.example.danielspeixoto.meufinanceiro.module.TransactionSource;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.SourceRecyclerAdapter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public abstract class SourceActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;
    protected SourceRecyclerAdapter mAdapter = new SourceRecyclerAdapter(this);

    protected void onCreate(Bundle savedInstanceState, int layout, TransactionSource.Presenter presenter) {
        super.onCreate(savedInstanceState, layout);
        mAdapter.setPresenter(presenter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(mAdapter);
        new SwipeHelper((viewHolder, direction) -> {
            switch (direction) {
                case SwipeHelper.RIGHT:
                    mAdapter.togglePayed(viewHolder.getLayoutPosition());
                    break;
            }
        }).attachToRecyclerView(list);
    }

}
