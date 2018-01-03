package com.example.jdagnogo.fifaatome.ui.contract;

import android.graphics.Typeface;

import com.ramotion.circlemenu.CircleMenuView;

/*
Stuff specify to MainActivity
 */
public interface MainContract extends BaseContract {

    void initTextFont(Typeface tf);

    void initMenuListener(CircleMenuView.EventListener listener);

}
