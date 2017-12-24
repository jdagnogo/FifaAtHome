package com.example.jdagnogo.fifaatome.presenter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.enums.CircleMenuItemEnum;
import com.example.jdagnogo.fifaatome.ui.views.MainView;
import com.ramotion.circlemenu.CircleMenuView;

public class MainPresenter<V extends MainView> implements BasePresenter<V> {
    private V view;

    @Override
    public void onResume() {
        view.initMenuListener(initMenuListener());
        view.initTextFont(initFont());
    }

    private Typeface initFont() {
       return Typeface.createFromAsset(FifaAtome.getContext().getAssets(), "font.ttf");
    }

    private CircleMenuView.EventListener initMenuListener(){
        final Activity activity = view.getActivity();
       return new CircleMenuView.EventListener() {
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
                CircleMenuItemEnum.values()[index].handleClick(activity);
            }
        };
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void init(V view) {
        this.view = view;
    }
}
