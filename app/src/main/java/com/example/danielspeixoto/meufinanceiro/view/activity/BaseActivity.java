package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseActivity extends AppCompatActivity implements Base.View {

    protected static final String EMPTY_STRING = "";

    public final String TAG = getClass().getSimpleName();

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public BaseActivity getActivity() {
        return this;
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }
}
