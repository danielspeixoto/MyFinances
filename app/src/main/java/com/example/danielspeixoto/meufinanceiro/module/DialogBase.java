package com.example.danielspeixoto.meufinanceiro.module;

import com.example.danielspeixoto.meufinanceiro.view.dialog.BaseDialog;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public class DialogBase {

    public interface View {
        BaseDialog getDialog();
    }

    public interface Presenter {

    }
}
