package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Frequency;
import com.example.danielspeixoto.meufinanceiro.module.InsertTransaction;
import com.example.danielspeixoto.meufinanceiro.module.InstitutionSource;
import com.example.danielspeixoto.meufinanceiro.presenter.AllInstitutionsPresenter;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.util.DateString;

public class InsertTransactionActivity extends DataTransactionActivity implements InsertTransaction.View, InstitutionSource.View {

    InsertTransaction.Presenter mPresenter = new InsertTransactionPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String today = DateString.getToday();
        first_text.setText(today);
        second_text.setText(today);
        new AllInstitutionsPresenter(this).selectAll();
    }

    @Override
    protected void save() {
        super.save();
        if(checkTextNotNull(numberOfTimes)) {
            mPresenter.insert(mTransaction, Integer.valueOf(numberOfTimes.getText().toString()), ((Frequency)frequencySpinner.getSelectedItem()).getValue());
        } else {
            mPresenter.insert(mTransaction);
        }
        numberOfTimes.setText(EMPTY_STRING);
    }
}
