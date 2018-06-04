package com.example.jdagnogo.fifaatome.ui.activities;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.VsPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.VsContract;
import com.trello.rxlifecycle2.components.RxActivity;

public class VsActivity extends BaseActivity implements VsContract{

    private VsPresenter vsPresenter;

    @Override
    public RxActivity getActivity() {
        return this;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_vs;
    }

    @Override
    protected void initPresenter() {
        presenter.onAttach(this);
    }

    @Override
    protected BasePresenter setPresenter() {
        presenter = new VsPresenter();
        vsPresenter = (VsPresenter) presenter;
        return presenter;
    }
}
