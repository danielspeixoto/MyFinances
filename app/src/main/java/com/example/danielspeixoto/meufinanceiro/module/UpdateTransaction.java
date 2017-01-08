package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Transaction;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class UpdateTransaction {

    public interface View<T> extends ActivityBase.View {

        void setRelatedItemIndex(int index);

        void addItem(Institution institution);
    }

    public interface Presenter<T> extends ActivityBase.Presenter {

        void update(T t);

        void update(Transaction transaction, int amount, int frequency);

        void selectInstitutions(String id);

    }
}
