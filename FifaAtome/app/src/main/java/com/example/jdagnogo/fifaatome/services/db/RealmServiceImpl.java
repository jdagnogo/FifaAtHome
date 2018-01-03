package com.example.jdagnogo.fifaatome.services.db;

import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.realm.Realm;
import io.realm.RealmResults;

// we want to have realm object only here

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
    public void saveUser(final User user) {
        final UserRealm userRealm = new UserRealm(user);
        realm.beginTransaction();
        realm.copyToRealm(userRealm);
        realm.commitTransaction();

    }

    @Override
    public Flowable<ArrayList<User>> loadUsers() {
     return  realm.where(UserRealm.class)
                .findAll()
                .asFlowable()
                .map((RealmResults<UserRealm> userRealms) -> {
                    //transforme userRealm => user
                    ArrayList<User> users = new ArrayList<>();
                    for (int i = 0; i < userRealms.size(); i++) {
                        users.add(new User(userRealms.get(i)));
                    }
                    return users;
                });

    }

    @Override
    public void deleteUser(User user) {

    }


}
