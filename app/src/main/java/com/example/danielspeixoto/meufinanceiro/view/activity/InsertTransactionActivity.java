package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.presenter.AllInstitutionsPresenter;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertTransactionPresenter;

public class InsertTransactionActivity extends DataTransactionActivity implements CRUD.Insert.View<Transaction>, CRUD.All.View<Institution> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AllInstitutionsPresenter(this).selectAll();
    }

    @Override
    protected void save() {
        super.save();
        new InsertTransactionPresenter(this).insert(mTransaction);
    }
}
