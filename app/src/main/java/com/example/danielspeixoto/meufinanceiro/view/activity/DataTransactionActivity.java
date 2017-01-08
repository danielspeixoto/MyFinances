package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.DateGetter;
import com.example.danielspeixoto.meufinanceiro.view.custom.FrequencySpinner;
import com.example.danielspeixoto.meufinanceiro.view.dialog.DateDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 1/3/17.
 */

public abstract class DataTransactionActivity extends BaseActivity {

    Transaction mTransaction = new Transaction();
    ArrayList<Institution> institutions = new ArrayList<>();
    ArrayAdapter mAdapter;

    @BindView(R.id.descriptionEdit)
    EditText descriptionEdit;
    @BindView(R.id.amountEdit)
    EditText amountEdit;
    @BindView(R.id.institutionSpinner)
    Spinner institutionSpinner;
    @BindView(R.id.debtButton)
    RadioButton debtButton;
    @BindView(R.id.frequencyRelative)
    RelativeLayout frequencyRelative;
    @BindView(R.id.repeatsSwitch)
    Switch repeatsSwitch;
    @BindView(R.id.numberOfTimes)
    EditText numberOfTimes;
    @BindView(R.id.frequencySpinner)
    FrequencySpinner frequencySpinner;
    @BindView(R.id.first_text)
    TextView first_text;
    @BindView(R.id.second_text)
    TextView second_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_transaction_data);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutions);
        institutionSpinner.setAdapter(mAdapter);
    }

    @OnClick(R.id.startDateButton)
    public void selectStartDate() {
        selectDateDialog(first_text);
    }

    @OnClick(R.id.endDateButton)
    public void selectEndDate() {
        selectDateDialog(second_text);
    }

    public void selectDateDialog(TextView textView) {
        DateGetter.View dateGetter =  new DateDialog(this, textView::setText);
        dateGetter.setDate(textView.getText().toString());
        dateGetter.show();
    }

    public void addItem(Institution institution) {
        institutions.add(institution);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.repeatsSwitch)
    public void toggleGridLayout() {
        if(repeatsSwitch.isChecked()) {
            frequencyRelative.setVisibility(View.VISIBLE);
        } else {
            frequencyRelative.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fab)
    protected void save() {
        if(!amountEdit.getText().toString().equals(EMPTY_STRING)) {
            mTransaction.setAmount(Double.valueOf(amountEdit.getText().toString()));
            mTransaction.setDescription(descriptionEdit.getText().toString());
            mTransaction.setLaunchedDate(first_text.getText().toString());
            mTransaction.setExpirationDate(second_text.getText().toString());
            mTransaction.setDebt(debtButton.isChecked());
            mTransaction.setInstitutionId(((Institution)institutionSpinner.getSelectedItem()).getId());
        } else {
            showMessage("Amount must have a value");
        }
    }
}
