package com.example.danielspeixoto.meufinanceiro.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class GroupOfChildrenListener extends ChildAddedListener {

    public GroupOfChildrenListener(Actions mAction) {
        super(mAction);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        super.onCancelled(databaseError);
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        dataSnapshot.getRef().addChildEventListener(new ChildAddedListener(new Actions() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mAction.onChildAdded(dataSnapshot, s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mAction.onCancelled(databaseError);
            }
        }));
    }
}
