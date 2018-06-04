package com.example.jdagnogo.fifaatome.utils;

import android.app.Activity;
import android.widget.Toast;


public class FlashBarUtils {

    public static void createFlashBarError(Activity activity, String msg){
        Toast.makeText(activity, msg,
                Toast.LENGTH_LONG).show();
    }
}
