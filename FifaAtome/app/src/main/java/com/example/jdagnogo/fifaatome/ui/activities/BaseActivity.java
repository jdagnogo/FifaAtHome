package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.ui.contract.BaseContract;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxActivity implements BaseContract {
    protected Unbinder binder;
    protected BasePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        //onAttach butterknife and presenter
        binder = ButterKnife.bind(this);
        presenter = setPresenter();
        initPresenter();
        Log.d(BaseActivity.class.getSimpleName(), "---------INIT : butterKnife, presenter ------");


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
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
        presenter.onDetach();
        Log.d(BaseActivity.class.getSimpleName(), "---------RELEASE : butterKnife, presenter ------");

//release butterknife, presenter, close realm ?
    }
}
