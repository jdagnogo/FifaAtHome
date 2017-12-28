package com.example.jdagnogo.fifaatome.services.db;

import com.example.jdagnogo.fifaatome.models.entities.UserRealm;

import io.realm.RealmResults;

public interface DbManager {

    void closeDb();

    void saveUser(UserRealm userRealm);

    RealmResults<UserRealm> load();

    void deleteUser(UserRealm userRealm);

}
