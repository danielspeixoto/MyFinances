package com.example.danielspeixoto.meufinanceiro.presenter;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.CRUDInstitutions;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.module.InsertInstitution;
import com.example.danielspeixoto.meufinanceiro.util.Validate;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertInstitutionPresenter implements InsertInstitution.Presenter {

    private final InsertInstitution.View mView;
    private CRUDInstitutions mCRUD;
    String result;

    public InsertInstitutionPresenter(InsertInstitution.View mView) {
        this.mView = mView;
        try {
            mCRUD = new CRUDInstitutions();
        } catch (NoUserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Institution institution) {
        result = Validate.institution(institution);
        if(result.equals(Validate.SUCCESS)) {
            mCRUD.insert(institution);
            mView.getDialog().dismiss();
            result = "Institution has been created";
        }
        mView.getDialog().getActivity().showMessage(result);
    }

}
