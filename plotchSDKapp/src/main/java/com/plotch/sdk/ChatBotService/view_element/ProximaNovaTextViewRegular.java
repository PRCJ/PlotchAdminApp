package com.plotch.sdk.ChatBotService.view_element;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by venkateshpamarthi on 23/08/16.
 */
public class ProximaNovaTextViewRegular extends AppCompatTextView {

    private static Typeface proximaNovaRegularTypeface;

    public ProximaNovaTextViewRegular(Context context) {
        super(context);
        init();
    }

    public ProximaNovaTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProximaNovaTextViewRegular(Context context, AttributeSet attrs, int defStyleAttr) {
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
