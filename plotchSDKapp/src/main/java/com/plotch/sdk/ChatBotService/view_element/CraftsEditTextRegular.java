package com.plotch.sdk.ChatBotService.view_element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by root on 26/8/16.
 */
public class CraftsEditTextRegular extends AppCompatEditText {

    private static Typeface proximaNovaRegularTypeface;

    public CraftsEditTextRegular(Context context) {
        super(context);
        init();
    }

    public CraftsEditTextRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CraftsEditTextRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (proximaNovaRegularTypeface == null) {
                proximaNovaRegularTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/proximanova_regular.ttf");
            }
            setTypeface(proximaNovaRegularTypeface);
        }
    }
}