package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danielspeixoto on 1/3/17.
 */

public abstract class DataInstitutionActivity extends BaseActivity {

    Institution institution = new Institution();

    @BindView(R.id.nameEdit)
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution_data);
        ButterKnife.bind(this);
        setUpToolbar();
    }

    @OnClick(R.id.fab)
    protected void save() {
        institution.setName(nameEdit.getText().toString());
    }
}
