package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.module.DeleteTransaction;
import com.example.danielspeixoto.meufinanceiro.module.SelectInstitution;
import com.example.danielspeixoto.meufinanceiro.presenter.DeleteTransactionPresenter;
import com.example.danielspeixoto.meufinanceiro.presenter.SelectInstitutionPresenter;

import butterknife.BindView;

public class InfoTransactionActivity extends BaseActivity implements SelectInstitution.View, DeleteTransaction.View {

    Transaction mTransaction;

    @BindView(R.id.descriptionText)
    TextView descriptionText;
    @BindView(R.id.amountText)
    TextView amountText;
    @BindView(R.id.launchedDateText)
    TextView launchedDateText;
    @BindView(R.id.expirationDateText)
    TextView expirationDateText;
    @BindView(R.id.institutionText)
    TextView institutionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_info);
        mTransaction = getIntent().getParcelableExtra(Transaction.class.getSimpleName());
        descriptionText.setText(mTransaction.getDescription());
        amountText.setText(Double.toString(mTransaction.getAmount()));
        launchedDateText.setText(mTransaction.getLaunchedDate());
        expirationDateText.setText(mTransaction.getExpirationDate());
        new SelectInstitutionPresenter(this).select(mTransaction.getInstitutionId());
    }

    @Override
    public void fillData(Institution institution) {
        institutionText.setText(institution.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_delete, menu);
        if(!mTransaction.getGroup().equals("General")) {
            menu.findItem(R.id.action_delete).setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Intent intent = new Intent(this, UpdateTransactionActivity.class);
                intent.putExtra(Transaction.class.getSimpleName(), mTransaction);
                startActivity(intent);
                finish();
                break;
            case R.id.action_delete:
                new DeleteTransactionPresenter(this).delete(mTransaction);
                break;
            case R.id.action_delete_all:
                new DeleteTransactionPresenter(this).delete(mTransaction.getGroup());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
