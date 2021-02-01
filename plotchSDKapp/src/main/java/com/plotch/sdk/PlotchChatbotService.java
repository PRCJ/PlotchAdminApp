package com.plotch.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.plotch.sdk.ChatBotService.ui.ChatbotActivity;
import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.data.ConfigData;
import com.plotch.sdk.network.Connectivity;
import com.plotch.sdk.network.GetDataService;
import com.plotch.sdk.network.RetrofitClientInstance;
import com.plotch.sdk.utils.DialogUtil;
import com.plotch.sdk.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlotchChatbotService {

    private static boolean isRetrying;

    public static void start(Context ctx, String AuthorisationToken, String CustomerId) {
        if (ctx != null) {
            String NotificationInstanceId = "";
            String AssistantInstanceId = "";
            String PlotchSecrateKey = "";

            String AssistantName = "";
            String AssistantIcon = "";
            String DefaultPrimaryColor = "";

            String AuthorisationTokenL = "";
            String CustomerIdL = "";
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
            try {
                PlotchSecrateKey = BuildConfig.PlotchSecretKey;
            } catch (Exception e) {
                PlotchSecrateKey = "";
            }
            try {
                AssistantName = PreferenceManager.getInstance(ctx).getChatBotName();
            } catch (Exception e) {
                AssistantName = "";
            }
            try {
                AssistantIcon = PreferenceManager.getInstance(ctx).getChatBotIcon();
            } catch (Exception e) {
                AssistantIcon = "";
            }
            try {
                DefaultPrimaryColor = PreferenceManager.getInstance(ctx).getChatBotDefaultPrimaryColor();
            } catch (Exception e) {
                DefaultPrimaryColor = "";
            }
            if (!TextUtils.isEmpty(AssistantInstanceId)) {
                AuthorisationTokenL = AuthorisationToken;
            } else {
                AuthorisationTokenL = "";
            }
            if (!TextUtils.isEmpty(CustomerId)) {
                CustomerIdL = CustomerId;
            } else {
                CustomerIdL = "";
            }
            if (!TextUtils.isEmpty(AssistantInstanceId)) {
                if (!TextUtils.isEmpty(AssistantName)) {
                    if (!TextUtils.isEmpty(PlotchSecrateKey)) {
                        if (!TextUtils.isEmpty(AssistantIcon)) {
                            Intent i = null;
                            try {
                                i = new Intent(ctx, ChatbotActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                i.putExtra("notification_instance_id", NotificationInstanceId);
                                i.putExtra("chatbot_instance_id", AssistantInstanceId);
                                i.putExtra("chatbot_name", AssistantName);
                                i.putExtra("chatbot_icon", AssistantIcon);
                                i.putExtra("auth_token", AuthorisationTokenL);
                                i.putExtra("customer_id", CustomerIdL);
                                i.putExtra("plotch_secret_key", PlotchSecrateKey);
                                i.putExtra("default_primary_color", DefaultPrimaryColor);
                                ctx.startActivity(i);
                            } catch (Exception e) {
                                Toast.makeText(ctx, "Something is wrong .", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(ctx, "Plotch icon invalid or not provided.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ctx, "Chatbot secret key invalid or not provided.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ctx, "Chatbot name invalid or not provided.", Toast.LENGTH_SHORT).show();
                    if (isRetrying) ;
                    initialiseAndLaunch(ctx, AuthorisationTokenL, CustomerIdL);
                }
            } else {
                Toast.makeText(ctx, "Chatbot instanceId invalid or not provided.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void initialise(Context context) {
        if (context != null) {
            Context ctx = context;
            PreferenceManager.getInstance(context);
            try {
                if (Connectivity.isConnected(context)) {
                    LogUtils.logE("run: INSIDE API");
                    GetDataService apiService = RetrofitClientInstance.getRetrofitInstanceEternal(context.getString(R.string.bot_api_external)).create(GetDataService.class);
                    Call<ConfigData> call = apiService.getConfigDetails(BuildConfig.ChatbotInstanceId);
                    call.enqueue(new Callback<ConfigData>() {
                        @Override
                        public void onResponse(Call<ConfigData> call, Response<ConfigData> result) {
                            if (result != null) {
                                LogUtils.logE("onResponse: " + "PlotchChatService sucesss" + result.toString());
                                if (result.body() != null) {
                                    PreferenceManager.getInstance(ctx).setChatBotName(result.body().d.getChatbotName());
                                    PreferenceManager.getInstance(ctx).setChatBotIcon(result.body().d.getChatbotImage());
                                    PreferenceManager.getInstance(ctx).setChatBotDescription(result.body().d.getChatbotDescription());
                                    PreferenceManager.getInstance(ctx).setChatBotDefaultPrimaryColor(result.body().d.getDefaultPrimaryColor());
                                }

                            } else {
                                LogUtils.logE("onResponse: " + "PlotchChatService init failure");
                            }
                        }

                        @Override
                        public void onFailure(Call<ConfigData> call, Throwable t) {
                            LogUtils.logE("onResponse: " + "PlotchChatService init failure");

                        }
                    });
                } else {
                    DialogUtil.showNoNetworkAlert(context);
                }


            } catch (Exception e) {
                LogUtils.logE("PlotchChatService init failure Exception" + e.getMessage());
                LogUtils.logE(e.toString());

            }

        }
    }


    public static void initialiseAndLaunch(Context context, String authorisationTokenL, String customerIdL) {
        if (context != null) {
            Context ctx = context;
            PreferenceManager.getInstance(context);
            try {
                if (Connectivity.isConnected(context)) {
                    LogUtils.logE("run: INSIDE API");
                    GetDataService apiService = RetrofitClientInstance.getRetrofitInstanceEternal(context.getString(R.string.bot_api_external)).create(GetDataService.class);
                    Call<ConfigData> call = apiService.getConfigDetails(BuildConfig.ChatbotInstanceId);
                    call.enqueue(new Callback<ConfigData>() {
                        @Override
                        public void onResponse(Call<ConfigData> call, Response<ConfigData> result) {
                            if (result != null) {
                                LogUtils.logE("onResponse: " + "PlotchChatService sucesss" + result.toString());
                                if (result.body() != null) {
                                    PreferenceManager.getInstance(ctx).setChatBotName(result.body().d.getChatbotName());
                                    PreferenceManager.getInstance(ctx).setChatBotIcon(result.body().d.getChatbotImage());
                                    PreferenceManager.getInstance(ctx).setChatBotDescription(result.body().d.getChatbotDescription());
                                    PreferenceManager.getInstance(ctx).setChatBotDefaultPrimaryColor(result.body().d.getDefaultPrimaryColor());
                                    isRetrying = true;
                                    start(ctx, authorisationTokenL, customerIdL);

                                }

                            } else {
                                LogUtils.logE("onResponse: " + "PlotchChatService init failure");
                            }
                        }

                        @Override
                        public void onFailure(Call<ConfigData> call, Throwable t) {
                            LogUtils.logE("onResponse: " + "PlotchChatService init failure");

                        }
                    });
                } else {
                    DialogUtil.showNoNetworkAlert(context);
                }


            } catch (Exception e) {
                LogUtils.logE("PlotchChatService init failure Exception" + e.getMessage());
                LogUtils.logE(e.toString());

            }

        }
    }
}

