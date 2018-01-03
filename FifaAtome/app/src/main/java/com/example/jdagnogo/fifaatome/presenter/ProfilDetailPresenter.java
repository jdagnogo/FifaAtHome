package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsDetailContract;

import io.realm.RealmResults;

public class ProfilDetailPresenter<V extends ProfilsDetailContract> implements BasePresenter<V> {

    UserRealm userRealm;
    private V view;

    @Override
    public void onResume() {
        loadUserInfo();
        view.fillTitle(userRealm.getFullName());
    }

    private void loadUserInfo() {
        userRealm = new UserRealm();
        userRealm.setName("TeteDeGland");
        userRealm.setFirstName("Roche");
       // FifaAtome.getDbManager().saveUser(new User(userRealm));


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
