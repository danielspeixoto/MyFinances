package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.module.ISelectAllModel;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.presenter.module.ISelectAllPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/5/17.
 */

public class AllInstitutionsModel implements ISelectAllModel<Institution> {

    private final ISelectAllPresenter<Institution> mSelectAllPresenter;
    private DatabaseReference mDatabase;

    public AllInstitutionsModel(ISelectAllPresenter mSelectAllPresenter) {
        this.mSelectAllPresenter = mSelectAllPresenter;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Institution.class.getSimpleName());
    }

    @Override
    public void selectAll() {
            mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mSelectAllPresenter.onReceiving(dataSnapshot.getValue(Institution.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
