package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;

import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.ProfilsPresenter;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsView;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfilsActivity extends BaseActivity implements ProfilsView {
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;
    ProfilsPresenter profilsPresenter;

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
        //this is ugly...
        presenter = new ProfilsPresenter();
        profilsPresenter = (ProfilsPresenter)presenter;
        return presenter;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    /*
    ButterKnife Click
     */
    @OnClick(R.id.fab)
    void onFabClick() {
       profilsPresenter.onFabClick();
    }
}
