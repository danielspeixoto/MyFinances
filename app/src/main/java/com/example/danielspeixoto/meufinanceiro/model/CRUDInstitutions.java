package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class CRUDInstitutions extends CRUD {

    public CRUDInstitutions() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Institution.class.getSimpleName());
    }

    public Observable<Institution> select(String id) {
        return Observable.create(new Observable.OnSubscribe<Institution>() {
            @Override
            public void call(Subscriber<? super Institution> subscriber) {
                mDatabase.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        subscriber.onNext(dataSnapshot.getValue(Institution.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public Observable<Institution> selectAll() {
        return Observable.create(new Observable.OnSubscribe<Institution>() {
            @Override
            public void call(final Subscriber<? super Institution> subscriber) {
                mDatabase.orderByChild("name").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        subscriber.onNext(dataSnapshot.getValue(Institution.class));
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
