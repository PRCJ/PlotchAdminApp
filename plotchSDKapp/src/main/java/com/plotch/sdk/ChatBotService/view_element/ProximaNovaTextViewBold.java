package com.plotch.sdk.ChatBotService.view_element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by venkateshpamarthi on 23/08/16.
 */
public class ProximaNovaTextViewBold extends AppCompatTextView {

    private static Typeface proximaNovaBoldTypeface;

    public ProximaNovaTextViewBold(Context context) {
        super(context);
        init();
    }

    public ProximaNovaTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProximaNovaTextViewBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (proximaNovaBoldTypeface == null) {
                proximaNovaBoldTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/proximanova_bold.ttf");
            }
            setTypeface(proximaNovaBoldTypeface);
        }
    }
}
