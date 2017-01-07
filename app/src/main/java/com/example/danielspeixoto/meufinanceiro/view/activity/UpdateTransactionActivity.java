package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Frequency;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.UpdateTransaction;
import com.example.danielspeixoto.meufinanceiro.presenter.UpdateTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.util.DateString;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 1/5/17.
 */
public class UpdateTransactionActivity extends DataTransactionActivity implements UpdateTransaction.View<Transaction> {

    @BindView(R.id.creditButton)
    RadioButton creditButton;
    @BindView(R.id.frequencyLinear)
    LinearLayout frequencyLinear;
    UpdateTransaction.Presenter<Transaction> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransaction = getIntent().getParcelableExtra(Transaction.class.getSimpleName());
        if(!mTransaction.getGroup().equals("General")) {
            // Only transactions in general can edit their repeatability
            frequencyLinear.setVisibility(View.GONE);
        }
        nameEdit.setText(mTransaction.getName());
        amountEdit.setText(Long.toString(mTransaction.getAmount()));
        DateString dateString = new DateString(mTransaction.getLaunchedDate());
        launchedDate.updateDate(dateString.stringToYear(), dateString.stringToMonth(), dateString.stringToDay());
        dateString.setDate(mTransaction.getExpirationDate());
        expirationDate.updateDate(dateString.stringToYear(), dateString.stringToMonth(), dateString.stringToDay());
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
        if(checkTextNotNull(numberOfTimes)) {
            mPresenter.update(mTransaction, Integer.valueOf(numberOfTimes.getText().toString()), ((Frequency)frequencySpinner.getSelectedItem()).getValue());
        } else {
            mPresenter.update(mTransaction);
        }
    }
}
