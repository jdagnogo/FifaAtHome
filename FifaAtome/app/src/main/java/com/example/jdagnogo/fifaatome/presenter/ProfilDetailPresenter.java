package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.models.User;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsDetailView;

public class ProfilDetailPresenter<V extends ProfilsDetailView> implements BasePresenter<V> {

    User user;
    private V view;

    @Override
    public void onResume() {
        loadUserInfo();
        view.fillTitle(user.getFullName());
    }

    private void loadUserInfo() {
        user = new User();
        user.setName("TeteDeGland");
        user.setFirstName("Roche");
    }


    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void init(V view) {
        this.view = view;
    }
}
