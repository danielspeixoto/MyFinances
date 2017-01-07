package com.example.danielspeixoto.meufinanceiro.module;

import android.content.Intent;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Login {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        int RC_SIGN_IN = 123;
        void logIn();
        void checkStatus();
        void onActivityResult(Intent data);
    }

}
