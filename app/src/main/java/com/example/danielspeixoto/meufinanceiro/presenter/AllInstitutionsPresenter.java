package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.AllInstitutionsModel;
import com.example.danielspeixoto.meufinanceiro.model.module.ISelectAllModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectAllPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IListView;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllInstitutionsPresenter implements ISelectAllPresenter<Institution> {

    private IListView<Institution> mListView;
    private ISelectAllModel<Institution> mSelectAllModel;

    public AllInstitutionsPresenter(IListView mListView) {
        this.mListView = mListView;
        this.mSelectAllModel = new AllInstitutionsModel(this);
    }

    @Override
    public void selectAll() {
        mSelectAllModel.selectAll();
    }

    @Override
    public void onReceiving(Institution institution) {
        mListView.addItem(institution);
    }

    @Override
    public void onError(String message) {
        mListView.onError(message);
    }
}
