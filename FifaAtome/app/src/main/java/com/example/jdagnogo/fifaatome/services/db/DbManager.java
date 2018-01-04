package com.example.jdagnogo.fifaatome.services.db;

import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.realm.RealmResults;

public interface DbManager {

    void closeDb();

    Flowable<Boolean> saveUser(User user);

    Flowable<Boolean> saveUsers(ArrayList<User> users);

    Flowable<ArrayList<User>>loadUsers();

    Flowable<Boolean> deleteUser(User user);

}
