package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IInsertView;

public class InsertTransactionActivity extends DataTransactionActivity implements IInsertView<Transaction> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void save() {
        super.save();
        new InsertTransactionPresenter(this).insert(mTransaction);
    }

    @Override
    public void onObjectInserted() {
        showMessage("Transaction has been successfully created");
    }

}
