package com.example.jdagnogo.fifaatome.services.db;

import com.example.jdagnogo.fifaatome.models.entities.UserRealm;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmServiceImpl implements DbManager {
    private final Realm realm;

    public RealmServiceImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void closeDb() {
        realm.close();
    }

    @Override
    public void saveUser(UserRealm userRealm) {
        realm.beginTransaction();
        realm.copyToRealm(userRealm);
        realm.commitTransaction();
    }

    @Override
    public RealmResults<UserRealm> load() {
        realm.beginTransaction();
        RealmQuery<UserRealm> query = realm.where(UserRealm.class);
        final RealmResults<UserRealm> resultRealm = query.findAll();
        realm.commitTransaction();
        return resultRealm;
    }

    @Override
    public void deleteUser(UserRealm userRealm) {

    }
}
