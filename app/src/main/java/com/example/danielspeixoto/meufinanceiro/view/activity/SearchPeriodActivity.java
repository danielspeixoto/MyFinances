package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.module.DateGetter;
import com.example.danielspeixoto.meufinanceiro.module.UpdateAmount;
import com.example.danielspeixoto.meufinanceiro.util.DateString;
import com.example.danielspeixoto.meufinanceiro.view.dialog.DateDialog;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.SearchPeriodRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchPeriodActivity extends BaseActivity implements UpdateAmount.View {

    @BindView(R.id.start_text)
    TextView start_text;
    @BindView(R.id.end_text)
    TextView end_text;
    @BindView(R.id.amountText)
    TextView amountText;
    @BindView(R.id.searchList)
    RecyclerView searchList;
    SearchPeriodRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_period);
        ButterKnife.bind(this);
        setUpToolbar();
        String today = DateString.getToday();
        start_text.setText(today);
        end_text.setText(today);
        mAdapter = new SearchPeriodRecyclerAdapter(this, this);
        searchList.setAdapter(mAdapter);
        searchList.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.fab)
    public void search() {
        mAdapter.setDates(start_text.getText().toString(), end_text.getText().toString());
    }

    @OnClick(R.id.startDateButton)
    public void selectStartDate() {
        selectDateDialog(start_text);
    }

    @OnClick(R.id.endDateButton)
    public void selectEndDate() {
        selectDateDialog(end_text);
    }

    public void selectDateDialog(TextView textView) {
        DateGetter.View dateGetter =  new DateDialog(this, textView::setText);
        dateGetter.setDate(textView.getText().toString());
        dateGetter.show();
    }

    @Override
    public void onAmountReceived(double amountOfMoney) {
        String amount = "+";
        if(amountOfMoney < 0) {
            amountText.setTextColor(Color.RED);
            amount = "-";
        }
        amount += "$" + Double.toString(amountOfMoney).substring(1);
        amountText.setText(amount);
    }
}
