package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Frequency;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.module.InsertTransaction;
import com.example.danielspeixoto.meufinanceiro.presenter.AllInstitutionsPresenter;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertTransactionPresenter;

public class InsertTransactionActivity extends DataTransactionActivity implements InsertTransaction.View, CRUD.All.View<Institution> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AllInstitutionsPresenter(this).selectAll();
    }

    @Override
    protected void save() {
        super.save();
        if(checkTextNotNull(numberOfTimes)) {
            new InsertTransactionPresenter(this).insert(mTransaction, Integer.valueOf(numberOfTimes.getText().toString()), ((Frequency)frequencySpinner.getSelectedItem()).getValue());
        } else {
            new InsertTransactionPresenter(this).insert(mTransaction);
        }
    }
}
