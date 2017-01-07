package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.presenter.PayedPresenter;

public class PayedActivity extends SourceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_payed, new PayedPresenter(mAdapter));
    }

}
