package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.view.View;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.view.activity.BaseActivity;
import com.example.danielspeixoto.meufinanceiro.view.activity.PayedActivity;
import com.example.danielspeixoto.meufinanceiro.view.activity.SearchPeriodActivity;
import com.example.danielspeixoto.meufinanceiro.view.dialog.InsertInstitutionDialog;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends BaseHolder {

    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;
    @Setter
    protected int index;
    private final BaseActivity mActivity;

    public DrawerHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
        mActivity = mAdapter.getActivity();
    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        switch (index) {
            case NEW_INSTITUTION:
                new InsertInstitutionDialog(mActivity).show();
                break;
            case SEARCH_PERIOD:
                mActivity.goToActivity(SearchPeriodActivity.class);
                break;
            case PAYED:
                mActivity.goToActivity(PayedActivity.class);
        }
    }

    private static final int NEW_INSTITUTION = 0;
    private static final int SEARCH_PERIOD = 1;
    private static final int PAYED = 2;

}
