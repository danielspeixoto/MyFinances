package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.module.Logout;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class LogoutPresenter implements Logout.Presenter {

    private FirebaseAuth mAuth;
    private final Logout.View mView;

    public LogoutPresenter(Logout.View mView) {
        mAuth = FirebaseAuth.getInstance();
        this.mView = mView;
    }

    @Override
    public void logOut() {
        mAuth.signOut();
        mView.getActivity().finish();
    }
}
