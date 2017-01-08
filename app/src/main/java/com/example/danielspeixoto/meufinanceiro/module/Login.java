package com.example.danielspeixoto.meufinanceiro.module;

import android.content.Intent;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Login {

    public interface View extends ActivityBase.View {
    }

    public interface Presenter extends ActivityBase.Presenter {
        int RC_SIGN_IN = 123;
        void logIn();
        void checkStatus();
        void onActivityResult(Intent data);
    }

}
