package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.module.DeleteTransaction;
import com.example.danielspeixoto.meufinanceiro.presenter.DeleteTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.presenter.SelectInstitutionPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoTransactionActivity extends BaseActivity implements CRUD.Select.View<Institution>, DeleteTransaction.View {

    Transaction mTransaction;

    @BindView(R.id.nameText)
    TextView nameText;
    @BindView(R.id.amountText)
    TextView amountText;
    @BindView(R.id.launchedDateText)
    TextView launchedDateText;
    @BindView(R.id.expirationDateText)
    TextView expirationDateText;
    @BindView(R.id.commentsText)
    TextView commentsText;
    @BindView(R.id.institutionText)
    TextView institutionText;
    @BindView(R.id.deleteAllButton)
    Button deleteAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        mTransaction = getIntent().getParcelableExtra(Transaction.class.getSimpleName());
        if(!mTransaction.getGroup().equals("General")) {
            deleteAllButton.setVisibility(View.VISIBLE);
        }
        nameText.setText(mTransaction.getName());
        amountText.setText(Long.toString(mTransaction.getAmount()));
        launchedDateText.setText(mTransaction.getLaunchedDate());
        expirationDateText.setText(mTransaction.getExpirationDate());
        commentsText.setText(mTransaction.getComments());
        new SelectInstitutionPresenter(this).select(mTransaction.getInstitutionId());
    }

    @Override
    public void fillData(Institution institution) {
        institutionText.setText(institution.getName());
    }

    @OnClick(R.id.editButton)
    public void update() {
        Intent intent = new Intent(this, UpdateTransactionActivity.class);
        intent.putExtra(Transaction.class.getSimpleName(), mTransaction);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.deleteButton)
    public void delete() {
        new DeleteTransactionPresenter(this).delete(mTransaction.getGroup(), mTransaction.getId());
    }

    @OnClick(R.id.deleteAllButton)
    public void deleteAll() {
        new DeleteTransactionPresenter(this).delete(mTransaction.getGroup());
    }
}
