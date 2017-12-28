package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.UserRealm;
import com.example.jdagnogo.fifaatome.services.db.DbManager;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsDetailView;

import io.realm.RealmResults;

public class ProfilDetailPresenter<V extends ProfilsDetailView> implements BasePresenter<V> {

    UserRealm userRealm;
    private V view;

    @Override
    public void onResume() {
        loadUserInfo();
        view.fillTitle(userRealm.getFullName());
    }

    private void loadUserInfo() {
        /*userRealm = new UserRealm();
        userRealm.setName("TeteDeGland");
        userRealm.setFirstName("Roche");
        FifaAtome.getDbManager().saveUser(userRealm);*/

        RealmResults<UserRealm> toto = FifaAtome.getDbManager().load();
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
