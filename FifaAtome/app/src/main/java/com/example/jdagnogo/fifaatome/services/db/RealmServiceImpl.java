package com.example.jdagnogo.fifaatome.services.db;

import android.util.Log;

import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

// we want to have realm object only here

public class RealmServiceImpl implements DbManager {

    //TODO clear realm with stetho
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
        return Flowable.fromCallable(() -> {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(realm1 -> {
                    realm1.insert(new UserRealm(user));
                });
            } catch (Exception e) {
                Log.e("SaveUser", "error : " + e.getMessage());
                return false;
            }
            Log.e("SaveUser", "succed : " + user.toString());
            return true;
        });
    }

    @Override
    public Flowable<Boolean> saveUsers(ArrayList<User> users) {
        return Flowable.fromCallable(() -> {
            try (Realm realm = Realm.getDefaultInstance()) {
                realm.executeTransaction(realm1 -> {
                    RealmList<UserRealm> _newsList = new RealmList<>();
                    for (User user : users) {
                        _newsList.add(new UserRealm(user));
                    }
                    realm1.insert(_newsList);
                });
            } catch (Exception e) {
                Log.e("SaveUsers", "error : " + e.getMessage());
                return false;
            }
            Log.e("SaveUser", "succed : " + users.toString());
            return true;
        });
    }


    @Override
    public Flowable<User> loadUserById(int id) {
        return realm.where(UserRealm.class)
                .equalTo(UserRealm.SPEUDO,"5")
                .findFirst()
                .asFlowable()
                .map(realmObject -> new User((UserRealm)realmObject));
    }

    @Override
    public Flowable<ArrayList<User>> loadAllUsers() {
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
