package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
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

public class CRUDTransactions extends CRUD {

    public CRUDTransactions() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(Transaction.class.getSimpleName());
    }

    public Observable<Transaction> select(String id) {
        return Observable.create(new Observable.OnSubscribe<Transaction>() {
            @Override
            public void call(Subscriber<? super Transaction> subscriber) {
                mDatabase.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        subscriber.onNext(dataSnapshot.getValue(Transaction.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        subscriber.onError(new Throwable(databaseError.getMessage()));
                    }
                });
            }
        });
    }

    public Observable<Transaction> selectAll() {
        return Observable.create(new Observable.OnSubscribe<Transaction>() {
            @Override
            public void call(final Subscriber<? super Transaction> subscriber) {
                mDatabase.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        subscriber.onNext(dataSnapshot.getValue(Transaction.class));
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
                        subscriber.onError(new Throwable(databaseError.getMessage()));
                    }
                });
            }
        });
    }

    public void insert(Transaction transaction) {
        transaction.setId(mDatabase.push().getKey());
        mDatabase.child(transaction.getId()).setValue(transaction);
    }

    public void update(Transaction transaction) {
        mDatabase.child(transaction.getId()).setValue(transaction);
    }

}
