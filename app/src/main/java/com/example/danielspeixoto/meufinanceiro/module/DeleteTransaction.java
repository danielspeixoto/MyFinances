package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class DeleteTransaction {

    public interface View extends Base.View{

    }

    public interface Presenter extends Base.Presenter {

        void delete(String id);

        void delete(String groupId, String id);

    }
}
