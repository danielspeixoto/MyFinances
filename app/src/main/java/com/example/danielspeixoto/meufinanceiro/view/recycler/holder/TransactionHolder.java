package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.util.DateString;
import com.example.danielspeixoto.meufinanceiro.view.activity.InfoTransactionActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;
import lombok.Setter;

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
    @Setter
    Transaction transaction;

    public TransactionHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    public void onPostCreated() {
        setId(transaction.getId());
        getAmountText().setText("$" + transaction.getAmount());
        getNameText().setText(transaction.getName());
        getExpirationText().setText(transaction.getExpirationDate());
        if(transaction.getExpirationDate().equals(DateString.getToday())) {
            nameText.setTextColor(Color.rgb(0, 128, 0));
            amountText.setTextColor(Color.rgb(0, 128, 0));
            expirationText.setTextColor(Color.rgb(0, 128, 0));
            if(transaction.isDebt()) {
                nameText.setTextColor(Color.RED);
                amountText.setTextColor(Color.RED);
                expirationText.setTextColor(Color.RED);
            }
        }
    }

    @OnClick(R.id.cardItem)
    public void itemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), InfoTransactionActivity.class);
        intent.putExtra(Transaction.class.getSimpleName(), (Transaction) getSelf());
        mAdapter.getActivity().startActivity(intent);
    }
}
