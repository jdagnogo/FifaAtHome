package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.ProfilDetailPresenter;
import com.example.jdagnogo.fifaatome.ui.views.ProfilsDetailView;

import butterknife.BindView;

public class ProfilsDetailActivity extends BaseActivity implements ProfilsDetailView {

    @BindView(R.id.title)
    TextView titleTextView;

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_profil_detail;
    }

    @Override
    protected void initPresenter() {
        presenter.init(this);
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
