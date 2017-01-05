package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected static final String EMPTY_STRING = "";

    public final String TAG = getClass().getSimpleName();

    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
