package com.example.jdagnogo.fifaatome.ui.contract;

import android.app.Activity;

import com.trello.rxlifecycle2.components.RxActivity;

/*
    Stuff that all views will have to do
 */
public interface BaseContract {

    RxActivity getActivity();

    void showLoading();

    void hideLoading();
}
