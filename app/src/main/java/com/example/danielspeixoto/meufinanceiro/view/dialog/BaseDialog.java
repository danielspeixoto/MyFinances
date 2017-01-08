package com.example.danielspeixoto.meufinanceiro.view.dialog;

import android.app.Dialog;

import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

import lombok.Getter;

/**
 * Created by danielspeixoto on 1/8/17.
 */

public abstract class BaseDialog extends Dialog {

    @Getter
    protected BaseActivity activity;

    public BaseDialog(BaseActivity activity) {
        super(activity);
    }
}
