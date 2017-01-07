package com.example.danielspeixoto.meufinanceiro.module;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class UpdateAmount {

    public interface View extends Base.View {

        void onAmountReceived(double amountOfMoney);

    }

    public interface Presenter extends Base.Presenter {

    }
}
