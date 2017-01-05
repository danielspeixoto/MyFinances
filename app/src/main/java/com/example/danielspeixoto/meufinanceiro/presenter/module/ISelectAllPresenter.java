package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISelectAllPresenter<T> extends IBaseModule {

    void selectAll();

    void onReceiving(T t);

}
