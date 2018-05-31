package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.MainPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.MainContract;
import com.ramotion.circlemenu.CircleMenuView;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.BindView;

/*
An Activty is like Jon Snow : they now nothing !
 */
public class MainActivity extends BaseActivity implements MainContract {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.circle_menu)
    CircleMenuView menu;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        presenter.onAttach(this);
    }

    @Override
    protected BasePresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initTextFont(Typeface tf) {
        title.setTypeface(tf);
    }

    @Override
    public void initMenuListener(CircleMenuView.EventListener listener) {
        menu.setEventListener(listener);
    }

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
}
