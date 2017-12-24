package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.Base.BaseActivity;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.Base.BasePresenter;
import com.example.jdagnogo.fifaatome.models.enums.CircleMenuItemEnum;
import com.example.jdagnogo.fifaatome.presenter.MainPresenter;
import com.example.jdagnogo.fifaatome.ui.views.MainView;
import com.ramotion.circlemenu.CircleMenuView;

import butterknife.BindView;

/*
An Activty is like Jon Snow : they now nothing !
 */
public class MainActivity extends BaseActivity implements MainView {

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
        presenter.init(this);
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
    public Activity getActivity() {
        return this;
    }
}
