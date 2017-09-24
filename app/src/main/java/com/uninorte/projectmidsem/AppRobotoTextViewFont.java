package com.uninorte.projectmidsem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppRobotoTextViewFont  extends android.support.v7.widget.AppCompatTextView{

    private int typefaceType;
    private RobotoFamily mFontFactory;

    public AppRobotoTextViewFont(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public AppRobotoTextViewFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    public AppRobotoTextViewFont(Context context) {
        super(context);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {


        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);
        try {
            typefaceType = array.getInteger(R.styleable.CustomTextView_font_name, 0);
        } finally {
            array.recycle();
        }
        if (!isInEditMode()) {
            setTypeface(getTypeFace(typefaceType));
        }

    }

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new RobotoFamily(getContext());

        switch (type) {
            case Constants.ROBOTO_BOLD:
                return mFontFactory.robotoBold;

            case Constants.ROBOTO_LIGHT:
                return mFontFactory.robotoLight;

            case Constants.ROBOTO_REGULAR:
                return mFontFactory.robotoRegular;

            case Constants.ROBOTO_ITALIC:
                return mFontFactory.robotoItalic;

            case Constants.ROBOTO_BLACK:
                return mFontFactory.robotoBlack;

            case Constants.ROBOTO_MEDIUM:
                return mFontFactory.robotoBlack;

            default:
                return mFontFactory.robotoMedium;
        }
    }

    public interface Constants {
        int ROBOTO_BOLD = 1,
                ROBOTO_LIGHT = 2,
                ROBOTO_REGULAR = 3,
                ROBOTO_ITALIC = 4,
                ROBOTO_BLACK=5,
                ROBOTO_MEDIUM = 6;
    }


}
