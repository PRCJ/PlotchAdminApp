package com.plotch.sdk.utils;

import android.util.Log;


public class LogUtils {

    private static final boolean DEBUG = true;
    private static final String TAG = "CRAFTSVILLA APP";

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logD(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void logD(String tag, String msg) {
        if (DEBUG) {
            Log.e(TAG + " : " + tag, msg);
        }
    }

    public static void logD(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.e(TAG + " : " + tag, msg, e);
        }
    }

    public static void logE(String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void logE(String tag, String msg) {
        if (DEBUG) {
            Log.e(TAG + " : " + tag, msg);
        }
    }

    public static void logE(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.e(TAG + " : " + tag, msg, e);
        }
    }

    public static void logE(String tag, String msg, Throwable e) {
        if (DEBUG) {
            Log.e(TAG + " : " + tag, msg, e);
        }
    }

    public static void logI(String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void logI(String tag, String msg) {
        if (DEBUG) {
            Log.i(TAG + " : " + tag, msg);
        }
    }

    public static void logV(String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void logV(String tag, String msg) {
        if (DEBUG) {
            Log.v(TAG + " : " + tag, msg);
        }
    }

    public static void logW(String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void logW(String tag, String msg) {
        if (DEBUG) {
            Log.w(TAG + " : " + tag, msg);
        }
    }

    public static void logWTF(String msg) {
        if (DEBUG) {
            Log.wtf(TAG, msg);
        }
    }

    public static void logWTF(String tag, String msg) {
        if (DEBUG) {
            Log.wtf(TAG + " : " + tag, msg);
        }
    }

}
