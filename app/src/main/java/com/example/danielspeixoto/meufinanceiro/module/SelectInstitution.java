package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class SelectInstitution {

    public interface View extends Base.View {

        void fillData(Institution institution);

    }

    public interface Presenter extends Base.Presenter {

        void select(String id);

    }
}
