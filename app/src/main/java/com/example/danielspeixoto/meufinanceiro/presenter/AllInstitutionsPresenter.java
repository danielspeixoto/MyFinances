package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.util.NoUserException;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllInstitutionsPresenter implements CRUD.All.Presenter<Institution> {

    private CRUD.All.View<Institution> mView;

    public AllInstitutionsPresenter(CRUD.All.View mView) {
        this.mView = mView;
    }

    @Override
    public void selectAll() {
        try {
            new CRUDInstitutions().selectAll().subscribe(new Subscriber<Institution>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Institution institution) {
                    mView.addItem(institution);
                }
            });
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }
}
