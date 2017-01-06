package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface ISelectPresenter<T> extends Base.Presenter {

    void select(String id);

    void onReceived(T t);

}
