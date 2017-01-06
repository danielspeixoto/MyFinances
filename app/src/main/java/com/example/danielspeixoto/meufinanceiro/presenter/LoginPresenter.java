package com.example.danielspeixoto.meufinanceiro.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.danielspeixoto.meufinanceiro.module.Login;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class LoginPresenter implements Login.Presenter, GoogleApiClient.OnConnectionFailedListener {

    private FirebaseAuth mAuth;
    private final Login.View mView;

    public LoginPresenter(Login.View mView) {
        mAuth = FirebaseAuth.getInstance();
        this.mView = mView;
    }

    @Override
    public void logIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("232659945439-ljdupa190imc5ji517t8tghp50ropakh.apps.googleusercontent.com")
                .requestEmail()
                .build();
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(mView.getActivity())
                .enableAutoManage(mView.getActivity(), this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        mView.getActivity().startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void checkStatus() {
        if(mAuth.getCurrentUser() != null) {
            mView.onLoggedIn();
        }
    }

    @Override
    public void onActivityResult(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            firebaseAuthWithGoogle(account);
            mView.onLoggedIn();
        } else {
            mView.onError("An error occurred");
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(mView.getActivity(), task -> {
                    if (!task.isSuccessful()) {
                        mView.onError("Authentication failed.");
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        mView.onError("Connection was not established");
    }
}
