package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.SelectInstitutionModel;
import com.example.danielspeixoto.meufinanceiro.model.module.ISelectModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.ISelectView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class SelectInstitutionPresenter implements ISelectPresenter<Institution> {

    private ISelectView<Institution> mSelectView;
    private ISelectModel<Institution> mSelectModel;

    public SelectInstitutionPresenter(ISelectView mSelectView) {
        this.mSelectView = mSelectView;
        this.mSelectModel = new SelectInstitutionModel(this);
    }

    @Override
    public void select(String id) {
        mSelectModel.select(id);
    }

    @Override
    public void onReceived(Institution institution) {
        mSelectView.fillData(institution);
    }

    @Override
    public void onError(String message) {

    }
}
