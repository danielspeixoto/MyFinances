package com.example.danielspeixoto.meufinanceiro.view.activity;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertInstitutionPresenter;
import com.example.danielspeixoto.meufinanceiro.view.module.IInsertView;

public class InsertInstitutionActivity extends InstitutionDataActivity implements IInsertView<Institution>{

    @Override
    protected void save() {
        super.save();
        new InsertInstitutionPresenter(this).insert(institution);
    }

    @Override
    public void onObjectInserted() {
        showMessage("Institution has been created");
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }
}
