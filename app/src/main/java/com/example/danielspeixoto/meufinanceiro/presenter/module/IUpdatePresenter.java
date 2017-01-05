package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IUpdatePresenter<T> extends IBaseModule {

    void update(T t);

    void onUpdated();
}
