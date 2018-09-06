package com.bluemortar.customui;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


public class CustomEditText extends android.support.v7.widget.AppCompatEditText{

    public CustomEditText(Context context) {
        super(context);
        setFont();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context,  attrs);
        setFont();
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(),"fonts/OpenSans_Regular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
