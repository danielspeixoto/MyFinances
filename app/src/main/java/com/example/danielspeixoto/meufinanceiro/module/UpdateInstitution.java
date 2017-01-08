package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class UpdateInstitution {

    public interface View {

        void finalize();

    }

    public interface Presenter {

        void insert(Institution institution);

    }
}
