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

    @BindView(R.id.descriptionText)
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
        String amount = "+";
        if(transaction.isDebt()) {
            nameText.setTextColor(Color.RED);
            amountText.setTextColor(Color.RED);
            expirationText.setTextColor(Color.RED);
            amount = "-";
        }
        if(!transaction.isPayed() &&
                DateString.compareDates(transaction.getExpirationDate(), DateString.getToday()) <= 0) {
            nameText.setTextColor(Color.BLACK);
            amountText.setTextColor(Color.BLACK);
            expirationText.setTextColor(Color.BLACK);
        }
        amount += "$" + transaction.getAmount();
        getAmountText().setText(amount);
        getNameText().setText(transaction.getDescription());
        getExpirationText().setText(transaction.getExpirationDate());
    }

    @OnClick(R.id.cardItem)
    public void itemClicked() {
        Intent intent = new Intent(mAdapter.getActivity(), InfoTransactionActivity.class);
        intent.putExtra(Transaction.class.getSimpleName(), transaction);
        mAdapter.getActivity().startActivity(intent);
    }
}
