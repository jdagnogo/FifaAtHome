package com.example.jdagnogo.fifaatome;

import android.app.Application;
import android.content.Context;

import com.example.jdagnogo.fifaatome.services.dagger.components.AppComponent;
import com.example.jdagnogo.fifaatome.services.dagger.components.DaggerAppComponent;
import com.example.jdagnogo.fifaatome.services.dagger.modules.AppModule;
import com.example.jdagnogo.fifaatome.services.dagger.modules.DataModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FifaAtome extends Application {
    private static final FifaAtome instance = new FifaAtome();
    public static Context context;
    private static AppComponent appComponent;

    public FifaAtome() {
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        this.initializeInjector();
        initRealmConfiguration();
    }

    private void initializeInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }

    private void initRealmConfiguration() {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
