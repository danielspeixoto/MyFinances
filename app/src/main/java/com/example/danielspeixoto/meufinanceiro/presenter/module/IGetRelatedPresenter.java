package com.example.danielspeixoto.meufinanceiro.presenter.module;

import com.example.danielspeixoto.meufinanceiro.module.Base;

/**
 * Created by danielspeixoto on 20/11/16.
 */
public interface IGetRelatedPresenter<T> extends Base.Presenter {

    void getRelated(int parentId);

    void onReceivingRelated(T t);

}
