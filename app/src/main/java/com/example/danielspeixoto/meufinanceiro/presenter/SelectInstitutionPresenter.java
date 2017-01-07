package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.SelectInstitution;

import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class SelectInstitutionPresenter implements SelectInstitution.Presenter {

    private SelectInstitution.View mView;
    private CRUDInstitutions mCRUD;

    public SelectInstitutionPresenter(SelectInstitution.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDInstitutions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select(String id) {
        mCRUD.select(id).subscribe(new Subscriber<Institution>() {
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
