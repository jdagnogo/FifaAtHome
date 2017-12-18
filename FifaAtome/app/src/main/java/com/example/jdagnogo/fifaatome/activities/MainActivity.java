package com.example.jdagnogo.fifaatome.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.activities.BaseActivity;
import com.ramotion.circlemenu.CircleMenuView;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CircleMenuView menu = (CircleMenuView) findViewById(R.id.circle_menu);
        TextView title = findViewById(R.id.title);
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"font.ttf");
        title.setTypeface(tf);
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
            }
        });
    }
}
