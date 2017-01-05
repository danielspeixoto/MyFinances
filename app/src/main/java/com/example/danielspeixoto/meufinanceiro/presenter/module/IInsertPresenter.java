package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IInsertPresenter<T> extends IBaseModule {

    void insert(T t);

    void onInserted();

}
