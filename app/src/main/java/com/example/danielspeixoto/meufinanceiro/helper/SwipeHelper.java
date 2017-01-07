package com.example.danielspeixoto.meufinanceiro.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by danielspeixoto on 1/7/17.
 */

public class SwipeHelper extends ItemTouchHelper {

    public interface Callback {
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);
    }

    public SwipeHelper(Callback callback) {
        super(new SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                callback.onSwiped(viewHolder, direction);
;            }
        });
    }
}
