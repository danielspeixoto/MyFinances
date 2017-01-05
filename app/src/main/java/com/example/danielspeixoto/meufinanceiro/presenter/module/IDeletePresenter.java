package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IDeletePresenter<T> extends IBaseModule {

    void delete(String id);

    void onDeleted();

}
