package com.uninorte.projectmidsem;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class AppLoginHeaderFont extends android.support.v7.widget.AppCompatTextView {
    public AppLoginHeaderFont(Context context) {
        super(context);
        setFont();
    }
    public AppLoginHeaderFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public AppLoginHeaderFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/ScriptMTBold.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}