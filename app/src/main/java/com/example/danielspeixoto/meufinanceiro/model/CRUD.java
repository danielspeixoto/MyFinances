package com.example.danielspeixoto.meufinanceiro.model;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public abstract class CRUD {

    DatabaseReference mDatabase;

    public void delete(String id) {
        mDatabase.child(id).removeValue();
    }
}
