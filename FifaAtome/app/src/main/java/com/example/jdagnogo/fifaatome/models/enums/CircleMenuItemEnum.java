package com.example.jdagnogo.fifaatome.models.enums;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.jdagnogo.fifaatome.ui.activities.ProfilsActivity;

public enum CircleMenuItemEnum {
    //the order is very important
    PROFIL(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","PROFIL");
            Intent intent = new Intent(activity, ProfilsActivity.class);
            activity.startActivity(intent);
        }
    },
    SETTINGS(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","SETTINGS");
        }
    },
    VS(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","VS");
        }
    },
    TOURNAMENT(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","TOURNAMENT");
        }
    },
    LEAGUE(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","LEAGUE");
        }
    };

    public abstract void handleClick(Activity activity);

}
