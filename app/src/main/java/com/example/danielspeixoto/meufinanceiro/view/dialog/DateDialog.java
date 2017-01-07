package com.example.danielspeixoto.meufinanceiro.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.DatePicker;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.module.DateGetter;
import com.example.danielspeixoto.meufinanceiro.util.Convert;
import com.example.danielspeixoto.meufinanceiro.util.DateString;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class DateDialog extends Dialog implements DateGetter.View {

    @BindView(R.id.datePicker)
    DatePicker datePicker;
    DateGetter.Presenter mPresenter;

    public DateDialog(Context context, DateGetter.Presenter presenter) {
        super(context);
        this.setContentView(R.layout.date_dialog);
        ButterKnife.bind(this);
        mPresenter = presenter;
    }

    @Override
    public void setDate(String date) {
        DateString dateString = new DateString(date);
        datePicker.updateDate(dateString.stringToYear(), dateString.stringToMonth(), dateString.stringToDay());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.getDate(Convert.dateToString(datePicker));
    }
}
