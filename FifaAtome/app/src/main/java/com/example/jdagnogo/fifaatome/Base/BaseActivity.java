package com.example.jdagnogo.fifaatome.Base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.services.dagger.components.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends Activity implements BaseView{
    protected Unbinder binder;
    protected BasePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        //init butterknife and presenter
        binder = ButterKnife.bind(this);
        presenter = setPresenter();
        initPresenter();
        Log.d(BaseActivity.class.getSimpleName(),"---------INIT : butterKnife, presenter ------");

        setupComponent(FifaAtome.getAppComponent());

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    protected void setupComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    protected abstract int getLayoutResourceId();

    protected abstract void initPresenter();

    /*
    each activity has to declare who is their presenter => did not want to inject the presenter
     */
    protected abstract BasePresenter setPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binder.unbind();
        presenter.onDestroy();
        Log.d(BaseActivity.class.getSimpleName(),"---------RELEASE : butterKnife, presenter ------");

//release butterknife, presenter, close realm ?
    }
}
