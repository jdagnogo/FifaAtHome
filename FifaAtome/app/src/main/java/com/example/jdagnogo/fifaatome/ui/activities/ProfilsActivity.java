package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.ProfilsPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsContract;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfilsActivity extends BaseActivity implements ProfilsContract {
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @BindView(R.id.emptyadapter)
    LinearLayout emptyAdapterLayout;

    @BindView(R.id.loading)
    RelativeLayout loadingLayout;

    ProfilsPresenter profilsPresenter;



    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_profils;
    }

    @Override
    protected void initPresenter() {
        presenter.onAttach(this);
    }

    @Override
    protected BasePresenter setPresenter() {
        //this is ugly...
        presenter = new ProfilsPresenter();
        profilsPresenter = (ProfilsPresenter) presenter;
        return presenter;
    }

    @Override
    public RxActivity getActivity() {
        return this;
    }

    @Override
    public void showLoading() {
        recyclerView.setVisibility(View.GONE);
        emptyAdapterLayout.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        recyclerView.setVisibility(View.VISIBLE);
        emptyAdapterLayout.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.GONE);
    }

    /*
    ButterKnife Click
     */
    @OnClick(R.id.fab)
    void onFabClick() {
        profilsPresenter.onFabClick();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public void handleEmptyAdapter() {
        recyclerView.setVisibility(View.GONE);
        emptyAdapterLayout.setVisibility(View.VISIBLE);
        loadingLayout.setVisibility(View.GONE);
    }

}
