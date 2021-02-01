package com.plotch.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.plotch.sdk.data.FcmRequest;
import com.plotch.sdk.data.FcmUpdateData;
import com.plotch.sdk.network.Connectivity;
import com.plotch.sdk.network.GetDataService;
import com.plotch.sdk.network.RetrofitClientInstance;
import com.plotch.sdk.utils.DialogUtil;
import com.plotch.sdk.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlotchNotificationService {

    private static boolean checkPlayServices(Context ctx) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(ctx);
        return resultCode == ConnectionResult.SUCCESS;
    }

    public static void init(Context ctx) {
        if (ctx != null) {
            String NotificationInstanceId = "";
            String AssistantInstanceId = "";
            try {
                NotificationInstanceId = BuildConfig.NotificationInstanceId;
            } catch (Exception e) {
                NotificationInstanceId = "";
            }
            try {
                AssistantInstanceId = BuildConfig.ChatbotInstanceId;
            } catch (Exception e) {
                AssistantInstanceId = "";
            }
            if (!TextUtils.isEmpty(NotificationInstanceId)) {
                if (checkPlayServices(ctx)) {
                    FirebaseMessaging.getInstance().subscribeToTopic(NotificationInstanceId);
                    String finalNotificationInstanceId = NotificationInstanceId;
                    String finalAssistantInstanceId = AssistantInstanceId;
                    FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener((Activity) ctx, new OnSuccessListener<InstanceIdResult>() {
                        @Override
                        public void onSuccess(InstanceIdResult instanceIdResult) {
                            String FirebaseToken = instanceIdResult.getToken();
                            String FirebaseInstaneID = instanceIdResult.getId();

                            if (BuildConfig.DEBUG)
                                LogUtils.logE("onSuccess: FirebaseToken " + FirebaseToken + "\n---------FirebaseInstaneID " + FirebaseInstaneID);

                            FcmRequest fcmObj = new FcmRequest();
                            fcmObj.setChatbotInstanceId(finalNotificationInstanceId);
                            fcmObj.setNotificationInstanceId(finalAssistantInstanceId);
                            fcmObj.setFirebaseToken(FirebaseToken);
                            fcmObj.setFirebaseInstance(FirebaseInstaneID);
                            updateFcmData(ctx, fcmObj);


                        }

                    });
                }

            } else {
                Toast.makeText(ctx, "NotificationInstanceId Invalid or not provided", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void updateFcmData(Context context, FcmRequest fcmObj) {
        try {
            if (Connectivity.isConnected(context)) {
                LogUtils.logE("run: INSIDE API");
                GetDataService apiService = RetrofitClientInstance.getRetrofitInstanceEternal(context.getString(R.string.bot_api_external)).create(GetDataService.class);
                Call<FcmUpdateData> call = apiService.getFcmDataUpdata(fcmObj);
                call.enqueue(new Callback<FcmUpdateData>() {
                    @Override
                    public void onResponse(Call<FcmUpdateData> call, Response<FcmUpdateData> result) {
                        if (result != null) {
                            LogUtils.logE("onResponse: " + "Plotch init success");
                        } else {
                            LogUtils.logE("onResponse: " + "Plotch init failure");
                        }
                    }

                    @Override
                    public void onFailure(Call<FcmUpdateData> call, Throwable t) {
                        LogUtils.logE("onResponse: " + "Plotch init failure");

                    }
                });
            } else {
                DialogUtil.showNoNetworkAlert(context);
            }


        } catch (Exception e) {
            LogUtils.logE("Plotch init failure Exception" + e.getMessage());
            LogUtils.logE(e.toString());

        }
    }

}
