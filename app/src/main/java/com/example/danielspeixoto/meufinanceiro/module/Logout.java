package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class Logout {

    public interface View extends Base.View {}
    public interface Presenter extends Base.Presenter {
        void logOut();
    }
}