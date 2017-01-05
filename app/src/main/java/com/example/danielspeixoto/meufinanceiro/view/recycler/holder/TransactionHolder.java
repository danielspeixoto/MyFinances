package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import lombok.Getter;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class TransactionHolder extends ItemHolder {

    @BindView(R.id.nameText)
    @Getter
    TextView nameText;
    @BindView(R.id.expirationText)
    @Getter
    TextView expirationText;
    @BindView(R.id.amountText)
    @Getter
    TextView amountText;

    public TransactionHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }
}
