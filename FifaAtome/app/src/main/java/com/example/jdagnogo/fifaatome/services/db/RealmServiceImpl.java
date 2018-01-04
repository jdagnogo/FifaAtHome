package com.example.jdagnogo.fifaatome.services.db;

import android.util.Log;

import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.realm.Realm;
import io.realm.RealmList;
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
    public Flowable<Boolean> saveUser(final User user) {
        final UserRealm userRealm = new UserRealm(user);
        realm.beginTransaction();
        realm.copyToRealm(userRealm);
        realm.commitTransaction();
        return null;

    }

    @Override
    public Flowable<Boolean> saveUsers(ArrayList<User> users) {
        return Flowable.fromCallable(() -> {
            try(Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(realm1 -> {
                    RealmList<UserRealm> _newsList = new RealmList<>();
                    for (User user : users){
                        _newsList.add(new UserRealm(user));
                    }
                    realm1.insert(_newsList);
                });
            }
            catch (Exception e){
                Log.e("SaveUser","error : "+e.getMessage());
                return false;
            }
            return true;
        });
    }

    @Override
    public Flowable<ArrayList<User>> loadUsers() {
        return realm.where(UserRealm.class)
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
    public Flowable<Boolean> deleteUser(User user) {
        return null;
    }


}
