package com.example.jdagnogo.fifaatome.Base;

public interface BasePresenter<V extends BaseView> {

    void onResume();

    void onDestroy();

    void init(V view);
    //loading

    //show empty

    //show network error


}
