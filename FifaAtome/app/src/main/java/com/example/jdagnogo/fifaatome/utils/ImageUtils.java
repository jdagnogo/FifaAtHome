package com.example.jdagnogo.fifaatome.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.jdagnogo.fifaatome.FifaAtome;

import java.util.ArrayList;

public class ImageUtils {

    public  static Drawable getDrawableFromName(String name){
        Context context = FifaAtome.getContext();
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable",
                context.getPackageName());
        return resources.getDrawable(resourceId);
    }

    public static ArrayList<String> loadAllphotos(){
        ArrayList<String> photos = new ArrayList();
        photos.add("ic_pele");
        photos.add("ic_boy");
        photos.add("ic_pele");
        photos.add("ic_boy");
        photos.add("ic_pele");
        photos.add("ic_boy");
        return photos;
    }
}
