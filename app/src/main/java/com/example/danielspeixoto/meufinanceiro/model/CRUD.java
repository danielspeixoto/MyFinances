package com.example.danielspeixoto.meufinanceiro.model;

import com.example.danielspeixoto.meufinanceiro.helper.NoUserException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public abstract class CRUD {

    DatabaseReference mDatabase;

    public CRUD() throws NoUserException {
        try {
            mDatabase = FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        } catch (NullPointerException exception) {
            throw new NoUserException();
        }
    }

    public void delete(String id) {
        mDatabase.child(id).removeValue();
    }
}
