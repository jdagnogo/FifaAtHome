package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.ui.contract.BaseContract;

public interface BasePresenter<V extends BaseContract> {

    void onResume();

    void onDestroy();

    void init(V view);
    //loading

    //show empty

    //show network error


}
