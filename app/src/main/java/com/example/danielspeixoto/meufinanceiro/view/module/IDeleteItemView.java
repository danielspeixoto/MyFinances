package com.example.danielspeixoto.meufinanceiro.view.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public interface IDeleteItemView<T> extends IBaseModule {

    void onItemDeleted();
}