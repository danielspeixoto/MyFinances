package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IUpdatePresenter<T> extends Base.Presenter {

    void update(T t);

    void onUpdated();
}
