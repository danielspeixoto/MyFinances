package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.view.activity.InfoTransactionActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
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

    @OnClick(R.id.cardItem)
    public void itemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), InfoTransactionActivity.class);
        intent.putExtra(Transaction.class.getSimpleName(), (Transaction) mAdapter.getData().get(index));
        mAdapter.getActivity().startActivity(intent);
    }
}
