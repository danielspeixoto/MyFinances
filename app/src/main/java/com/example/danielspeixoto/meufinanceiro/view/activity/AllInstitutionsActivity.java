package com.example.danielspeixoto.meufinanceiro.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.example.danielspeixoto.meufinanceiro.R;
import com.example.danielspeixoto.meufinanceiro.model.pojo.Institution;

import butterknife.BindView;

public class AllInstitutionsActivity extends BaseActivity {

    @BindView(R.id.list)
    RecyclerView list;
    protected ArrayAdapter<Institution> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState, R.layout.activity_all_institutions);
//        list.setAdapter(mAdapter);
//        new SwipeHelper((viewHolder, direction) -> {
//            switch (direction) {
//                case SwipeHelper.RIGHT:
//                    break;
//            }
//        }).attachToRecyclerView(list);
    }

}
