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

import butterknife.BindView;

/**
 * Created by danielspeixoto on 1/5/17.
 */
public class UpdateTransactionActivity extends DataTransactionActivity implements UpdateTransaction.View<Transaction> {

    @BindView(R.id.creditButton)
    RadioButton creditButton;
    @BindView(R.id.frequencyLinear)
    LinearLayout frequencyLinear;
    UpdateTransaction.Presenter<Transaction> mPresenter = new UpdateTransactionPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransaction = getIntent().getParcelableExtra(Transaction.class.getSimpleName());
        mPresenter.selectInstitutions(mTransaction.getInstitutionId());
        if(!mTransaction.getGroup().equals("General")) {
            // Only transactions in general can edit their repeatability
            frequencyLinear.setVisibility(View.GONE);
        }
        descriptionEdit.setText(mTransaction.getDescription());
        amountEdit.setText(Double.toString(mTransaction.getAmount()));
        first_text.setText(mTransaction.getLaunchedDate());
        second_text.setText(mTransaction.getExpirationDate());
        if(mTransaction.isDebt()) {
            debtButton.toggle();
        } else {
            creditButton.toggle();
        }
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
