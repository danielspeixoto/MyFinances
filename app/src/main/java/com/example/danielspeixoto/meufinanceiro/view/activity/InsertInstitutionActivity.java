package com.example.danielspeixoto.meufinanceiro.view.activity;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.CRUD;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertInstitutionPresenter;

public class InsertInstitutionActivity extends DataInstitutionActivity implements CRUD.Insert.View<Institution> {

    @Override
    protected void save() {
        super.save();
        new InsertInstitutionPresenter(this).insert(institution);
    }
}
