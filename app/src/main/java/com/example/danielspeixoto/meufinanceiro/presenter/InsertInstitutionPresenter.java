package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.InsertInstitutionModel;
import com.example.danielspeixoto.meufinanceiro.model.module.IInsertModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IInsertPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IInsertView;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertInstitutionPresenter implements IInsertPresenter<Institution> {

    private final IInsertView<Institution> mView;
    private final IInsertModel<Institution> mModel;

    public InsertInstitutionPresenter(IInsertView<Institution> mView) {
        this.mView = mView;
        this.mModel = new InsertInstitutionModel(this);
    }

    @Override
    public void insert(Institution institution) {
        mModel.insert(institution);
    }

    @Override
    public void onInserted() {
        mView.onObjectInserted();
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}
