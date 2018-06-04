package com.example.jdagnogo.fifaatome.models.enums;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.jdagnogo.fifaatome.ui.activities.ProfilsActivity;
import com.example.jdagnogo.fifaatome.ui.activities.VsActivity;

public enum CircleMenuItemEnum {
    //the order is very important
    PROFIL(){
        public void handleClick(Activity activity) {
            launchActicity(activity, ProfilsActivity.class);
        }
    },
    SETTINGS(){
        public void handleClick(Activity activity) {
            Log.d("CircleMenuItemEnum","SETTINGS");
        }
    },
    VS(){
        public void handleClick(Activity activity) {
            launchActicity(activity, VsActivity.class);
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

    private static void launchActicity(Activity activity,Class c){
        Intent intent = new Intent(activity,c);
        activity.startActivity(intent);
    }

}
