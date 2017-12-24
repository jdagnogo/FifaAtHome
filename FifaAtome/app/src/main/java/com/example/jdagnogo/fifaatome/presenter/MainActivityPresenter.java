package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.Base.BasePresenter;
import com.example.jdagnogo.fifaatome.ui.views.MainView;

import java.lang.ref.WeakReference;

public class MainActivityPresenter<V extends MainView> implements BasePresenter<V> {
    private V view;

    @Override
    public void onResume() {
        view.initListeners();
        view.initTextFont();
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void init(V view) {
        this.view = view;
    }
}
