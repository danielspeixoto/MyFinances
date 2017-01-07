package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.helper.ChildAddedListener;
import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import rx.Observable;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class CRUDInstitutions extends CRUD {

    public CRUDInstitutions() throws NoUserException {
        super();
        mDatabase = mDatabase.child(Institution.class.getSimpleName());
    }

    public Observable<Institution> select(String id) {
        return Observable.create(subscriber -> {
            mDatabase.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    subscriber.onNext(dataSnapshot.getValue(Institution.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    subscriber.onError(new Throwable(databaseError.getMessage()));
                }
            });
        });
    }

    public Observable<Institution> selectAll() {
        return Observable.create(subscriber -> {
            mDatabase.orderByChild("name").addChildEventListener(new ChildAddedListener(new ChildAddedListener.Actions() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    subscriber.onNext(dataSnapshot.getValue(Institution.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    subscriber.onError(new Throwable(databaseError.getMessage()));
                }
            }));
        });
    }

    public void insert(Institution institution) {
        institution.setId(mDatabase.push().getKey());
        mDatabase.child(institution.getId()).setValue(institution);
    }

    public void update(Institution institution) {
        mDatabase.child(institution.getId()).setValue(institution);
    }

}
