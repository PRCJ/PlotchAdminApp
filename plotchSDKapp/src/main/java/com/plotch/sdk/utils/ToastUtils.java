package com.plotch.sdk.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(Context context, String msg) {
        showToastNormal(context, msg);
    }

    public static void showToast(Context context, int resId) {
        showToastNormal(context, context.getString(resId));
    }

    public static void showToastNormal(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


}
