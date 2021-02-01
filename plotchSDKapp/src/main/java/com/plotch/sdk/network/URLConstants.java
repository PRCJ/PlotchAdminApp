package com.plotch.sdk.network;

import android.content.Context;

import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.utils.LogUtils;


public class URLConstants {
    public static final String VERSION_2 = "2";
    public static final String VERSION_2_SLASH = "/2";
    public static final String PERSONAL = "/personal";
    public static final String PUBLIC_PATH = "/public/" + VERSION_2;
    public static final String PINCODE_ADDRESS_CHECK = "/api/v1/checkout/pincodeDetails?";
    public static final String GET_CHAT_RESPONSE = "/v2/bot";
    public static final String GET_FCM_UPDATE = "/api/v1/sdk/updateFcm";
    public static final String GET_CONFIG = "/api/v1/sdk/configDetails";
    public static String BASE_PRODUCT_IMAGE_URL = "http://img6.craftsvilla.com/image/upload/";
    public static final String IMAGE_MEDIUM_URL = BASE_PRODUCT_IMAGE_URL + "f_auto,q_auto,fl_lossy,t_500x500_2";
    public static final String IMAGE_SMALL_URL = BASE_PRODUCT_IMAGE_URL + "f_auto,q_auto,fl_lossy,t_500x500_2";//"f_auto,q_auto,fl_lossy,t_216x216_2";
    public static final String IMAGE_ORIGINAL_URL = BASE_PRODUCT_IMAGE_URL + "w_800,c_lfill,f_auto,q_auto,g_auto,fl_lossy,e_sharpen";
    private static String debugModeBaseUrl = null;

    public static String getResolvedUrl(String suffix, Context ctx) {
        if (debugModeBaseUrl != null) {
            return debugModeBaseUrl + suffix;
        }

        String val = PreferenceManager.getInstance(ctx).getBaseUrl();
        LogUtils.logE("getResolvedUrl: " + val);
        if (val != null) {
            return val + suffix;
        } else {
            return ctx.getString(R.string.bot_api) + suffix;
        }
    }

    public static String getResolvedUrlOther(String suffix, Context ctx) {
        if (debugModeBaseUrl != null) {
            return debugModeBaseUrl + suffix;
        }

        String val = PreferenceManager.getInstance(ctx).getBaseUrl();
        LogUtils.logE("getResolvedUrl: " + val);
        if (val != null) {
            return val + suffix;
        } else {
            return ctx.getString(R.string.bot_api_external) + suffix;
        }
    }

    public static String getImageUrl(Context ctx, String suffix, ImageType type) {
        String base = PreferenceManager.getInstance(ctx).getImageBaseUrl(type);
        if (base != null) {
            return base + suffix;
        }

        switch (type) {
            case SMALL:
                return IMAGE_SMALL_URL + suffix;
            case MEDIUM:
                return IMAGE_MEDIUM_URL + suffix;
            case LARGE:
            default:
                return IMAGE_ORIGINAL_URL + suffix;

        }

    }

    public enum ImageType {
        SMALL, MEDIUM, LARGE, CATEGORY
    }
}
