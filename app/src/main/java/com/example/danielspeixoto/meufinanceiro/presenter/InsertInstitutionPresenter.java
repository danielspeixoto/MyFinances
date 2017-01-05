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

    private final IInsertView<Institution> mInsertView;
    private final IInsertModel<Institution> mInsertModel;

    public InsertInstitutionPresenter(IInsertView<Institution> mInsertView) {
        this.mInsertView = mInsertView;
        this.mInsertModel = new InsertInstitutionModel(this);
    }

    @Override
    public void insert(Institution institution) {
        mInsertModel.insert(institution);
    }

    @Override
    public void onInserted() {
        mInsertView.onObjectInserted();
    }

    @Override
    public void onError(String message) {
        mInsertView.onError(message);
    }
}
