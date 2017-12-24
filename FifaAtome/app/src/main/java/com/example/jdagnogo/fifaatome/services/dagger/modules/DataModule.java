package com.example.jdagnogo.fifaatome.services.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class DataModule {

    // This allow us to pass only one instance of realm to all activty
    @Singleton
    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
