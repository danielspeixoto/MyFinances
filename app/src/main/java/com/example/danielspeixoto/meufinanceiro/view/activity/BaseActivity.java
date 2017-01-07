package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.module.Base;

import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseActivity extends AppCompatActivity implements Base.View {

    protected static final String EMPTY_STRING = "";

    public final String TAG = getClass().getSimpleName();

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public BaseActivity getActivity() {
        return this;
    }

    public void goToActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected boolean checkTextNotNull(EditText editText) {
        return !editText.getText().toString().equals("");
    }
}
