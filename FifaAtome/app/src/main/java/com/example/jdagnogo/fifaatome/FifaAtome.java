package com.example.jdagnogo.fifaatome;

import android.app.Application;
import android.content.Context;

public class FifaAtome extends Application{
    private static final FifaAtome instance = new FifaAtome();
    private static Context context;

    public static FifaAtome getInstance() {
        return instance;
    }
    public static Context getContext() {
        return context;
    }
    public FifaAtome() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
