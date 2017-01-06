package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.module.Login;
import com.example.danielspeixoto.meufinanceiro.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.danielspeixoto.meufinanceiro.module.Login.Presenter.RC_SIGN_IN;

public class LoginActivity extends BaseActivity implements Login.View {

    private Login.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(this);
        mPresenter.checkStatus();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.googleSignIn)
    public void signIn() {
        mPresenter.logIn();
    }

    @Override
    public void onLoggedIn() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            mPresenter.onActivityResult(data);
        }
    }
}
