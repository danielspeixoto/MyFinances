package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 13/11/16.
 */
public interface IAllPresenter<T> extends Base.Presenter {

    void selectAll();

    void onReceiving(T t);

}
