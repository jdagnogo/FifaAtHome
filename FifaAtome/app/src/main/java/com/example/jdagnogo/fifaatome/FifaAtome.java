package com.example.jdagnogo.fifaatome;

import android.app.Application;
import android.content.Context;

import com.example.jdagnogo.fifaatome.services.db.DbManager;
import com.example.jdagnogo.fifaatome.services.db.RealmServiceImpl;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FifaAtome extends Application {
    public static  FifaAtome instance ;
    private DbManager dbManager;


    public FifaAtome() {
    }

    public static DbManager getDbManager() {
        return instance.dbManager;
    }

    private static Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    public static Context getContext() {
        return instance.getBaseContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRealmConfiguration();
        dbManager = new RealmServiceImpl(getRealm());
    }


    private void initRealmConfiguration() {
        Realm.init(getContext());
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }

}
