package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;

import com.example.jdagnogo.fifaatome.Base.BaseActivity;
import com.example.jdagnogo.fifaatome.Base.BasePresenter;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.ProfilsPresenter;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsView;

public class ProfilsActivity extends BaseActivity implements ProfilsView{

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_profils;
    }

    @Override
    protected void initPresenter() {
        presenter.init(this);
    }

    @Override
    protected BasePresenter setPresenter() {
        return new ProfilsPresenter();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
