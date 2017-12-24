package com.example.jdagnogo.fifaatome.presenter;

import android.content.Intent;

import com.example.jdagnogo.fifaatome.ui.activities.ProfilsDetailActivity;
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
        this.view = view;
    }

    public  void onFabClick(){
        Intent intent = new Intent(view.getActivity(), ProfilsDetailActivity.class);
        view.getActivity().startActivity(intent);
    }

}
