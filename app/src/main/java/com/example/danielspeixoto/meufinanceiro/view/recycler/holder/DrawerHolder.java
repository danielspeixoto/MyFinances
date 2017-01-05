package com.example.danielspeixoto.meufinanceiro.view.recycler.holder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.view.activity.InsertInstitutionActivity;
import com.example.danielspeixoto.meufinanceiro.view.recycler.adapter.BaseRecyclerAdapter;

import butterknife.BindView;
import butterknife.OnClick;
import lombok.Getter;

/**
 * Created by danielspeixoto on 05/12/16.
 */

public class DrawerHolder extends BaseHolder {

    @BindView(R.id.drawer_text)
    @Getter
    TextView drawerText;

    public DrawerHolder(View itemView, BaseRecyclerAdapter mAdapter) {
        super(itemView, mAdapter);
    }

    @OnClick(R.id.drawer_item)
    public void itemClicked() {
        switch (index) {
            case 0:
                mAdapter.getActivity().startActivity(new Intent(mAdapter.getActivity(), InsertInstitutionActivity.class));
                break;
        }
    }
}
