package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;
import com.example.danielspeixoto.meufinanceiro.util.ChildAddedListener;
import com.example.danielspeixoto.meufinanceiro.util.DateString;
import com.example.danielspeixoto.meufinanceiro.util.GroupOfChildrenListener;
import com.example.danielspeixoto.meufinanceiro.util.NoUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

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

    public void delete(String groupId, String id) {
        mDatabase.child(groupId).child(id).removeValue();
    }

    public Observable<Transaction> selectInPeriod(String startDate, String endDate) {
        return Observable.create(subscriber -> {
            selectAll().subscribe(new Subscriber<Transaction>() {

                String expirationDate;

                @Override
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                @Override
                public void onError(Throwable e) {
                    subscriber.onError(e);
                }

                @Override
                public void onNext(Transaction transaction) {
                    expirationDate = transaction.getExpirationDate();
                    if(DateString.compareDates(expirationDate, startDate) <= 0 &&
                            DateString.compareDates(expirationDate, endDate) >= 0) {
                        subscriber.onNext(transaction);
                    }
                }
            });
        });

    }
}
