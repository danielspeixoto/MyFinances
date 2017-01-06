package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioButton;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.presenter.UpdateTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IUpdateView;

import butterknife.BindView;

/**
 * Created by danielspeixoto on 1/5/17.
 */
public class UpdateTransactionActivity extends DataTransactionActivity implements IUpdateView<Transaction> {

    @BindView(R.id.creditButton)
    RadioButton creditButton;

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
    }

    @Override
    public void save() {
        super.save();
        new UpdateTransactionPresenter(this).update(mTransaction);
    }

    @Override
    public void addItem(Institution institution) {
        super.addItem(institution);
        if(institution.getId().equals(mTransaction.getInstitutionId())) {
            institutionSpinner.setSelection(institutions.size() - 1);
        }
    }

    @Override
    public void onObjectUpdated() {
        showMessage("Transaction updated");
        finish();
    }
}
