package com.example.danielspeixoto.meufinanceiro.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.danielspeixoto.meufinanceiro.presenter.module.IDeletePresenter;

/**
 * Created by danielspeixoto on 18/11/16.
 */
public abstract class BaseEditDeleteDialog extends DialogFragment {

    public static final String TAG = "editDelete";
    protected static final String ID = "_id";
    protected IDeletePresenter mDeletePresenter;
    protected long id;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setItems(new CharSequence[]{"Edit", "Delete"},
                        (dialog, which) -> {
                            switch (which) {
                                case 0:
                                    onEditClicked();
                                    break;
                                case 1:
                                    new AreYouSureDialog(() -> mDeletePresenter.delete(id))
                                            .show(getFragmentManager(), AreYouSureDialog.TAG);
                                    break;
                            }
                        }).create();
    }

    public abstract void onEditClicked();
}
