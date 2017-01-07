package com.example.danielspeixoto.meufinanceiro.util;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class ChildAddedListener implements ChildEventListener {

    protected final Actions mAction;

    public ChildAddedListener(Actions mAction) {
        this.mAction = mAction;
    }

    public interface Actions {
        void onChildAdded(DataSnapshot dataSnapshot, String s);
        void onCancelled(DatabaseError databaseError);
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        mAction.onChildAdded(dataSnapshot, s);
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
        mAction.onCancelled(databaseError);
    }
}
