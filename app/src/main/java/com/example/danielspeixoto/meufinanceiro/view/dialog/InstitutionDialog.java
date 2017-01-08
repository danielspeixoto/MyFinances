package com.example.danielspeixoto.meufinanceiro.view.dialog;

import android.widget.EditText;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 1/8/17.
 */

abstract class InstitutionDialog extends BaseDialog {

    protected Institution institution = new Institution();

    @BindView(R.id.nameEdit)
    EditText nameEdit;

    InstitutionDialog(BaseActivity activity) {
        super(activity);
        this.activity = activity;
        this.setContentView(R.layout.dialog_institution_data);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.saveButton)
    protected void save() {
        institution.setName(nameEdit.getText().toString());
    }

    public BaseDialog getDialog() {
        return this;
    }

}
