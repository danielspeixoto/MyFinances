package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.AllInstitutionsModel;
import com.example.danielspeixoto.meufinanceiro.model.module.ISelectAllModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IAllPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IAllView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllInstitutionsPresenter implements IAllPresenter<Institution> {

    private IAllView<Institution> mView;
    private ISelectAllModel<Institution> mModel;

    public AllInstitutionsPresenter(IAllView mView) {
        this.mView = mView;
        this.mModel = new AllInstitutionsModel(this);
    }

    @Override
    public void selectAll() {
        mModel.selectAll();
    }

    @Override
    public void onReceiving(Institution institution) {
        mView.addItem(institution);
    }

    @Override
    public void onError(String message) {
        mView.onError(message);
    }
}
