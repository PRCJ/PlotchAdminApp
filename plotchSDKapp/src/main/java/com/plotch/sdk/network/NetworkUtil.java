package com.plotch.sdk.network;

import android.content.Context;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkUtil {

    public static boolean isNetworkAvailable(Context context, boolean showToast) {

        NetworkInfo info = Connectivity.getNetworkInfo(context);
        if ((info != null && info.isConnected())) {
            return true;
        }

        if (showToast) {
            Toast.makeText(context, "Network connectivity", Toast.LENGTH_SHORT).show();
        }
        return false;//(info != null && info.isConnected());

        //return false;
    }

}
