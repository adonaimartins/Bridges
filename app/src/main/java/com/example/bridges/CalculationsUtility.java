package com.example.bridges;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class CalculationsUtility {

    private CalculationsUtility(){
    }
    public static int toDp(int myPixels){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        int dp = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, myPixels, displaymetrics );
        return dp;
    }

    public static float convertPixelsToDp(float px, Context context){
        return px * context.getResources().getDisplayMetrics().density;
    }
}
