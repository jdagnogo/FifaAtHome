package com.example.jdagnogo.fifaatome.ui.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.Base.BaseActivity;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.Base.BasePresenter;
import com.example.jdagnogo.fifaatome.models.enums.CircleMenuItemEnum;
import com.example.jdagnogo.fifaatome.presenter.MainActivityPresenter;
import com.example.jdagnogo.fifaatome.ui.views.MainView;
import com.ramotion.circlemenu.CircleMenuView;

import butterknife.BindView;


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
        return new MainActivityPresenter();
    }

    @Override
    public void initTextFont() {
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"font.ttf");
        title.setTypeface(tf);
    }

    @Override
    public void initListeners() {
        menu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationStart");
            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationEnd");
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationStart| index: " + index);
            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationEnd| index: " + index);
                CircleMenuItemEnum.values()[index].handleClick(MainActivity.this);
            }
        });
    }
}
