package com.bluemortar.customui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by ADMIN on 21-Sep-17.
 */

public class CustomButton extends android.support.v7.widget.AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        setFont();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(),"fonts/OpenSans_Regular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}

