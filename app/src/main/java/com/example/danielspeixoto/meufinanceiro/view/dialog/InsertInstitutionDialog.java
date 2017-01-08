package com.example.danielspeixoto.meufinanceiro.view.dialog;

import com.example.danielspeixoto.meufinanceiro.module.InsertInstitution;
import com.example.danielspeixoto.meufinanceiro.presenter.InsertInstitutionPresenter;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class InsertInstitutionDialog extends InstitutionDialog implements InsertInstitution.View {

    private InsertInstitution.Presenter mPresenter = new InsertInstitutionPresenter(this);

    public InsertInstitutionDialog(BaseActivity activity) {
        super(activity);
    }

    @Override
    protected void save() {
        super.save();
        mPresenter.insert(institution);
    }
}
