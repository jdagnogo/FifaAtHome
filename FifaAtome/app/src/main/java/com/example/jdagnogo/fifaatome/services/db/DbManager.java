package com.example.jdagnogo.fifaatome.services.db;

import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.realm.RealmResults;

public interface DbManager {

    void closeDb();

    void saveUser(User user);

    Flowable<ArrayList<User>>loadUsers();

    void deleteUser(User user);

}
