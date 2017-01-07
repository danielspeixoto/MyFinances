package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.InstitutionSource;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllInstitutionsPresenter implements InstitutionSource.Presenter {

    private InstitutionSource.View mView;
    private CRUDInstitutions mCRUD;

    public AllInstitutionsPresenter(InstitutionSource.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDInstitutions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll() {
        mCRUD.selectAll().subscribe(new Subscriber<Institution>() {
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
    }
}
