package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.ui.contract.BaseContract;

public interface BasePresenter<V extends BaseContract> {

    void onResume();

    void onDetach();

    void onAttach(V view);

    void showLoading();

    void hideLoading();


    //show empty?

    //show network error?


}
