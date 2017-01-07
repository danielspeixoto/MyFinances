package com.example.danielspeixoto.meufinanceiro.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.danielspeixoto.meufinanceiro.model.pojo.Frequency;

import java.util.ArrayList;

/**
 * Created by danielspeixoto on 1/6/17.
 */

public class FrequencySpinner extends Spinner {

    ArrayAdapter<Frequency> mAdapter;
    ArrayList<Frequency> mData = new ArrayList<>();

    public FrequencySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        mData.add(new Frequency("Monthly", -1));
        mData.add(new Frequency("Weekly", 7));
        mAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, mData);
        setAdapter(mAdapter);
    }

    //Todo add option to set a different frequency

}
