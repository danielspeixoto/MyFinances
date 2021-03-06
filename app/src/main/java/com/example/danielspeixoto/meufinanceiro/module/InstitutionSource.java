package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class InstitutionSource {

    public interface View extends ActivityBase.View {

        void addItem(Institution institution);

    }

    public interface Presenter extends ActivityBase.Presenter {

        void selectAll();

    }
}
