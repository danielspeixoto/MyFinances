package com.example.danielspeixoto.meufinanceiro.view.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISelectView<T> extends IBaseModule {

    void fillData(T t);
}
