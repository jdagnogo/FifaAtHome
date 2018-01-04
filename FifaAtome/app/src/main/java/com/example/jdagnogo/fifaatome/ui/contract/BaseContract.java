package com.example.jdagnogo.fifaatome.ui.contract;

import android.app.Activity;

/*
    Stuff that all views will have to do
 */
public interface BaseContract {

    Activity getActivity();

    void showLoading();

    void hideLoading();
}
