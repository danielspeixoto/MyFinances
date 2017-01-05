package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.util.IBaseModule;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public interface IGetRelatedPresenter<T> extends IBaseModule {

    void getRelated(int parentId);

    void onReceivingRelated(T t);

}
