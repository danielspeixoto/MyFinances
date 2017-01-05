package com.example.danielspeixoto.meufinanceiro.view.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IListView<T> extends IBaseModule {

    void addItem(T t);

}
