package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioButton;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.UpdateTransaction;
import com.example.danielspeixoto.meufinanceiro.presenter.UpdateTransactionPresenter;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 1/5/17.
 */
public class UpdateTransactionActivity extends DataTransactionActivity implements UpdateTransaction.View<Transaction> {

    @BindView(R.id.creditButton)
    RadioButton creditButton;
    UpdateTransaction.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransaction = getIntent().getParcelableExtra(Transaction.class.getSimpleName());
        nameEdit.setText(mTransaction.getName());
        amountEdit.setText(Long.toString(mTransaction.getAmount()));
        launchedDateEdit.setText(mTransaction.getLaunchedDate());
        expirationDateEdit.setText(mTransaction.getExpirationDate());
        commentsEdit.setText(mTransaction.getComments());
        if(mTransaction.isDebt()) {
            debtButton.toggle();
        } else {
            creditButton.toggle();
        }
        mPresenter = new UpdateTransactionPresenter(this);
    }

    @Override
    public void setRelatedItemIndex(int index) {
        institutionSpinner.setSelection(index);
    }

    @Override
    public void save() {
        super.save();

    }
}
