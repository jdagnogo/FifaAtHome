package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.Base.BasePresenter;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsView;

public class ProfilsPresenter<V extends ProfilsView> implements BasePresenter<V> {
    private V view;
    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void init(V view) {

    }


}
