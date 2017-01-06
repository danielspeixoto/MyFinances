package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class UpdateTransaction {

    public interface View<T> extends Base.View {

        void setRelatedItemIndex(int index);

        void addItem(Institution institution);
    }

    public interface Presenter<T> extends Base.Presenter {

        void update(T t);

        void selectInstitutions(String id);

    }
}
