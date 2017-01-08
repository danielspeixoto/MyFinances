package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Logout {

    public interface View extends ActivityBase.View {}
    public interface Presenter extends ActivityBase.Presenter {
        void logOut();
    }
}