package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.ui.views.BaseView;

public interface BasePresenter<V extends BaseView> {

    void onResume();

    void onDestroy();

    void init(V view);
    //loading

    //show empty

    //show network error


}
