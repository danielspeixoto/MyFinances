package com.example.danielspeixoto.meufinanceiro.view.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface ISelectView<T> extends Base.View {

    void fillData(T t);
}
