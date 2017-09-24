package com.uninorte.projectmidsem;

import android.content.Context;
import android.graphics.Typeface;

public class RobotoFamily {

    private String ROBOTO_BOLD= "fonts/Roboto-Bold.ttf";
    private String ROBOTO_LIGHT="fonts/Roboto-Light.ttf";
    private String ROBOTO_REGULAR= "fonts/Roboto-Regular.ttf";
    private String ROBOTO_ITALIC= "fonts/Roboto-Italic.ttf";
    private String ROBOTO_BLACK="fonts/Roboto-Black.ttf";
    private String ROBOTO_MEDIUM="fonts/Roboto-Medium.ttf";

    Typeface robotoBold;
    Typeface robotoLight;
    Typeface robotoRegular;
    Typeface robotoItalic;
    Typeface robotoBlack;
    Typeface robotoMedium;

    public RobotoFamily(Context context){
        robotoBold = Typeface.createFromAsset(context.getAssets(),ROBOTO_BOLD);
        robotoLight = Typeface.createFromAsset(context.getAssets(),ROBOTO_LIGHT);
        robotoRegular = Typeface.createFromAsset(context.getAssets(),ROBOTO_REGULAR);
        robotoItalic = Typeface.createFromAsset(context.getAssets(),ROBOTO_ITALIC);
        robotoBlack = Typeface.createFromAsset(context.getAssets(),ROBOTO_BLACK);
        robotoMedium = Typeface.createFromAsset(context.getAssets(),ROBOTO_MEDIUM);
    }

}