package com.example.danielspeixoto.meufinanceiro.presenter;

import android.content.Intent;

import com.example.danielspeixoto.meufinanceiro.module.Logout;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.activity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class LogoutPresenter implements Logout.Presenter {

    private FirebaseAuth mAuth;
    private final Logout.View mView;
    private final BaseActivity mActivity;

    public LogoutPresenter(Logout.View mView) {
        mAuth = FirebaseAuth.getInstance();
        mActivity = mView.getActivity();
        this.mView = mView;
    }

    @Override
    public void logOut() {
        mAuth.signOut();
        mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
        mActivity.finish();
    }
}
