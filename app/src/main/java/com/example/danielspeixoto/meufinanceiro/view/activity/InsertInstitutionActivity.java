package com.example.danielspeixoto.meufinanceiro.view.activity;

import com.example.danielspeixoto.meufinanceiro.module.InsertInstitution;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertInstitutionPresenter;

public class InsertInstitutionActivity extends DataInstitutionActivity implements InsertInstitution.View {

    @Override
    protected void save() {
        super.save();
        new InsertInstitutionPresenter(this).insert(institution);
    }
}
