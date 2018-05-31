package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.ProfilDetailPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsDetailContract;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.BindView;

public class ProfilsDetailActivity extends BaseActivity implements ProfilsDetailContract {

    @BindView(R.id.title)
    TextView titleTextView;

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
        return R.layout.activity_profil_detail;
    }

    @Override
    protected void initPresenter() {
        presenter.onAttach(this);
    }

    @Override
    protected BasePresenter setPresenter() {
        return new ProfilDetailPresenter();
    }

    @Override
    public void fillTitle(String title) {
        titleTextView.setText(title);
    }
}
