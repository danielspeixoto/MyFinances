package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 1/3/17.
 */

public abstract class DataTransactionActivity extends BaseActivity {

    Transaction mTransaction = new Transaction();
    ArrayList<Institution> institutions = new ArrayList<>();
    ArrayAdapter mAdapter;

    @BindView(R.id.nameEdit)
    EditText nameEdit;
    @BindView(R.id.amountEdit)
    EditText amountEdit;
    @BindView(R.id.launchedDateEdit)
    EditText launchedDateEdit;
    @BindView(R.id.expirationDateEdit)
    EditText expirationDateEdit;
    @BindView(R.id.commentsEdit)
    EditText commentsEdit;
    @BindView(R.id.institutionSpinner)
    Spinner institutionSpinner;
    @BindView(R.id.debtButton)
    RadioButton debtButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_data);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutions);
        institutionSpinner.setAdapter(mAdapter);
    }

    public void addItem(Institution institution) {
        institutions.add(institution);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.fab)
    protected void save() {
        mTransaction.setAmount(Long.valueOf(amountEdit.getText().toString()));
        mTransaction.setName(nameEdit.getText().toString());
        mTransaction.setLaunchedDate(launchedDateEdit.getText().toString());
        mTransaction.setExpirationDate(expirationDateEdit.getText().toString());
        mTransaction.setComments(commentsEdit.getText().toString());
        mTransaction.setDebt(debtButton.isChecked());
        mTransaction.setInstitutionId(((Institution)institutionSpinner.getSelectedItem()).getId());
    }
}
