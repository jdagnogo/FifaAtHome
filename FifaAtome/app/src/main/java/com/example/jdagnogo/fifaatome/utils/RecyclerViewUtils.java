package com.example.jdagnogo.fifaatome.utils;

import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewUtils {

    public static void initRecyclerView(RecyclerView recyclerView, Activity activity, boolean needDivider) {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        if (needDivider) {
            recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
        }

    }
}
