package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.IInsertModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.IInsertPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/4/17.
 */

public class InsertInstitutionModel implements IInsertModel<Institution> {

    private final IInsertPresenter<Institution> mInsertPresenter;
    private DatabaseReference mDatabase;

    public InsertInstitutionModel(IInsertPresenter<Institution> mInsertPresenter) {
        this.mInsertPresenter = mInsertPresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Institution.class.getSimpleName());
    }

    @Override
    public void insert(Institution institution) {
        institution.setId(mDatabase.push().getKey());
        mDatabase.child(institution.getId()).setValue(institution);
        mInsertPresenter.onInserted();
    }
}
