package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class SelectInstitutionPresenter implements CRUD.Select.Presenter<Institution> {

    private CRUD.Select.View<Institution> mView;

    public SelectInstitutionPresenter(CRUD.Select.View mView) {
        this.mView = mView;
    }

    @Override
    public void select(String id) {
        new CRUDInstitutions().select(id).subscribe(new Subscriber<Institution>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Institution institution) {
                mView.fillData(institution);
            }
        });
    }

}
