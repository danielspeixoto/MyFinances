package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 17/11/16.
 */
public interface IDeletePresenter<T> extends Base.Presenter {

    void delete(String id);

    void onDeleted();

}
