package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class InsertInstitution {

    public interface View extends DialogBase.View {

    }

    public interface Presenter extends DialogBase.Presenter {

        void insert(Institution institution);

    }

}
