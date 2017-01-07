package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.util.Convert;
import com.example.danielspeixoto.meufinanceiro.view.custom.FrequencySpinner;

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
    @BindView(R.id.commentsEdit)
    EditText commentsEdit;
    @BindView(R.id.institutionSpinner)
    Spinner institutionSpinner;
    @BindView(R.id.debtButton)
    RadioButton debtButton;
    @BindView(R.id.launchedDate)
    DatePicker launchedDate;
    @BindView(R.id.expirationDate)
    DatePicker expirationDate;
    @BindView(R.id.frequencyGrid)
    GridLayout frequencyGrid;
    @BindView(R.id.repeatsCheck)
    CheckBox repeatsCheck;
    @BindView(R.id.numberOfTimes)
    EditText numberOfTimes;
    @BindView(R.id.frequencySpinner)
    FrequencySpinner frequencySpinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_data);
        ButterKnife.bind(this);
        setUpToolbar();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutions);
        institutionSpinner.setAdapter(mAdapter);
    }

    public void addItem(Institution institution) {
        institutions.add(institution);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.repeatsCheck)
    public void toggleGridLayout() {
        if(repeatsCheck.isChecked()) {
            frequencyGrid.setVisibility(View.VISIBLE);
        } else {
            frequencyGrid.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fab)
    protected void save() {
        mTransaction.setAmount(Long.valueOf(amountEdit.getText().toString()));
        mTransaction.setName(nameEdit.getText().toString());
        mTransaction.setLaunchedDate(Convert.dateToString(launchedDate));
        mTransaction.setExpirationDate(Convert.dateToString(expirationDate));
        mTransaction.setComments(commentsEdit.getText().toString());
        mTransaction.setDebt(debtButton.isChecked());
        mTransaction.setInstitutionId(((Institution)institutionSpinner.getSelectedItem()).getId());
    }
}
