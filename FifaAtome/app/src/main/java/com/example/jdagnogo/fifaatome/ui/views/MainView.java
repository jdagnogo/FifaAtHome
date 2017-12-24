package com.example.jdagnogo.fifaatome.ui.views;

import android.graphics.Typeface;

import com.example.jdagnogo.fifaatome.Base.BaseView;
import com.ramotion.circlemenu.CircleMenuView;

/*
Stuff specify to MainActivity
 */
public interface MainView extends BaseView {

    void initTextFont(Typeface tf);

    void initMenuListener(CircleMenuView.EventListener listener);

}
