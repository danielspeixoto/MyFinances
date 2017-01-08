package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class UpdateAmount {

    public interface View extends ActivityBase.View {

        void onAmountReceived(double amountOfMoney);

    }

    public interface Presenter extends ActivityBase.Presenter {

    }
}
