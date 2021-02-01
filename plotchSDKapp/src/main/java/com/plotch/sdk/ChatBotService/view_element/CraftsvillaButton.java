package com.plotch.sdk.ChatBotService.view_element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

/**
 * Created by venkateshpamarthi on 24/08/16.
 */
public class CraftsvillaButton extends AppCompatButton {

    private static Typeface proximaNovaBoldTypeface;

    public CraftsvillaButton(Context context) {
        super(context);
        init();
    }

    public CraftsvillaButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CraftsvillaButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (proximaNovaBoldTypeface == null) {
            proximaNovaBoldTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/proximanova_regular.ttf");
        }
        setTypeface(proximaNovaBoldTypeface);
    }
}
