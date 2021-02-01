/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.plotch.sdk.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;

import com.plotch.sdk.R;
//import com.crashlytics.android.BuildConfig;
//import com.crashlytics.android.BuildConfig;


/**
 * Created by Mahesh Nayak on 04-03-2016.
 */
public class DialogUtil {

    public static AlertDialog dialogWithNoTitle(Context ctx, View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        AlertDialog dialog = builder.create();
        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setView(view);
        return dialog;
    }

    public static ProgressDialog getProgressDialog(Context ctx, String msg) {
        ProgressDialog dialog = new ProgressDialog(ctx);

        dialog.setMessage(msg);
        dialog.setTitle(R.string.app_name);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        return dialog;
    }

    public static void displayAlert(Context ctx, String title, String msg,
                                    int positiveBtnId, DialogInterface.OnClickListener positiveBtnListener) {
        try {
            if (ctx != null && title != null && msg != null)
                new AlertDialog.Builder(ctx).setTitle(title).setMessage(msg)
                        .setCancelable(false)
                        .setPositiveButton(positiveBtnId, positiveBtnListener)
                        .create().show();

        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

    public static void displayAlert(Context ctx, String title, String msg,
                                    int positiveBtnId, int cancelBtnId,
                                    DialogInterface.OnClickListener positiveBtnListener, DialogInterface.OnClickListener negBtnListener) {
        try {
            if (ctx != null && title != null && msg != null)
                new AlertDialog.Builder(ctx).setTitle(title).setMessage(msg)
                        .setCancelable(false)
                        .setPositiveButton(positiveBtnId, positiveBtnListener)
                        .setNegativeButton(cancelBtnId, negBtnListener)
                        .create().show();

        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays no network alert dialog. Msg - You are not connected to the
     * internet. Please check your internet connection. title - app name
     *
     * @param ctx
     */
    public static void showNoNetworkAlert(Context ctx) {
        try {
            showNoNetworkAlertForClose(ctx);
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

    public static void showNoNetworkAlertForClose(final Context ctx) {
        try {
            new android.app.AlertDialog.Builder(ctx).setTitle(R.string.app_name).setMessage(R.string.no_internet)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((Activity) ctx).finish();
                        }
                    }).create().show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }

}
