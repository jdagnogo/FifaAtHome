package com.example.jdagnogo.fifaatome.services.dagger.components;


import com.example.jdagnogo.fifaatome.Base.BaseActivity;
import com.example.jdagnogo.fifaatome.services.dagger.modules.AppModule;
import com.example.jdagnogo.fifaatome.services.dagger.modules.DataModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    void inject(BaseActivity baseActivity);

}
