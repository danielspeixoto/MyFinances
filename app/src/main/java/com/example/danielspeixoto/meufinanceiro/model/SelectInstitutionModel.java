package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.ISelectModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class SelectInstitutionModel implements ISelectModel<Institution> {

    private final ISelectPresenter<Institution> mSelectPresenter;
    private DatabaseReference mDatabase;

    public SelectInstitutionModel(ISelectPresenter mSelectPresenter) {
        this.mSelectPresenter = mSelectPresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Institution.class.getSimpleName());
    }

    @Override
    public void select(String id) {
        mDatabase.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mSelectPresenter.onReceived(dataSnapshot.getValue(Institution.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}