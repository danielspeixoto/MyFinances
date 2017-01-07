package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.helper.ChildAddedListener;
import com.example.danielspeixoto.meufinanceiro.helper.GroupOfChildrenListener;
import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.List;

import rx.Observable;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class CRUDTransactions extends CRUD {

    public CRUDTransactions() throws NoUserException {
        super();
        mDatabase = mDatabase.child(Transaction.class.getSimpleName());
    }

    public Observable<Transaction> selectAll() {
        return Observable.create(subscriber -> {
            mDatabase.addChildEventListener(new GroupOfChildrenListener(new ChildAddedListener.Actions() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    subscriber.onNext(dataSnapshot.getValue(Transaction.class));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    subscriber.onError(new Throwable(databaseError.getMessage()));
                    subscriber.onCompleted();
                }
            }));
        });
    }

    public void insert(Transaction transaction) {
        transaction.setId(mDatabase.child(transaction.getGroup()).push().getKey());
        mDatabase.child(transaction.getGroup()).child(transaction.getId()).setValue(transaction);
    }

    public void insert(List<Transaction> transactions) {
        String group = mDatabase.push().getKey();
        mDatabase = mDatabase.child(group);
        for(Transaction transaction : transactions) {
            transaction.setGroup(group);
            transaction.setId(mDatabase.child(transaction.getGroup()).push().getKey());
            mDatabase.child(transaction.getId()).setValue(transaction);
        }
    }

    public void update(Transaction transaction) {
        mDatabase.child(transaction.getGroup()).child(transaction.getId()).setValue(transaction);
    }

    public void delete(Transaction transaction) {
        mDatabase.child(transaction.getGroup()).child(transaction.getId()).removeValue();
    }
}
