package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.InsertInstitution;
import com.example.danielspeixoto.meufinanceiro.util.NoUserException;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertInstitutionPresenter implements InsertInstitution.Presenter {

    private final InsertInstitution.View mView;

    public InsertInstitutionPresenter(InsertInstitution.View mView) {
        this.mView = mView;
    }

    @Override
    public void insert(Institution institution) {
        try {
            new CRUDInstitutions().insert(institution);
        } catch (NoUserException e) {
            e.printStackTrace();
        }
        mView.getActivity().showMessage("Institution has been created");
    }

}
