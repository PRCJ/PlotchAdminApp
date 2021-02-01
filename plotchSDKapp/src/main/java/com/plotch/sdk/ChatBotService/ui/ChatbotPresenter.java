package com.plotch.sdk.ChatBotService.ui;

import android.content.Context;
import android.widget.Toast;

import com.plotch.sdk.ChatBotService.base.BasePresenter;
import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.data.AddressFromPinCode;
import com.plotch.sdk.data.ChatBotRequest;
import com.plotch.sdk.data.ChatBotResponse;
import com.plotch.sdk.data.PinCodeAddress;
import com.plotch.sdk.network.Connectivity;
import com.plotch.sdk.network.GetDataService;
import com.plotch.sdk.network.RetrofitClientInstance;
import com.plotch.sdk.utils.DialogUtil;
import com.plotch.sdk.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatbotPresenter extends BasePresenter<ChatbotContract.View> implements ChatbotContract.Presenter {
    public static final String TAG = "ProfilePresenter";

    @Override
    public void getChatData(final Context context, ChatBotRequest cbr) {
        try {

            if (Connectivity.isConnected(context)) {
                LogUtils.logE("run: INSIDE API");

                GetDataService apiServices = RetrofitClientInstance.getRetrofitInstance(context.getString(R.string.bot_api)).create(GetDataService.class);
                Call<ChatBotResponse> call = apiServices.getChatData(PreferenceManager.getInstance(context).getAuthToken(), PreferenceManager.getInstance(context).getPlotchSecretKey(), cbr);
                call.enqueue(new Callback<ChatBotResponse>() {
                    @Override
                    public void onResponse(Call<ChatBotResponse> call, Response<ChatBotResponse> result) {
                        if (result != null) {
                            LogUtils.logE("getChatData: request response--- " + result);
                            if (result.body() != null) {
                                if (getView() != null) {
                                    getView().hideLoadingIndicator();
                                    getView().setChatBotResponse(result.body());
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ChatBotResponse> call, Throwable t) {
                        Toast.makeText(context, t + "", Toast.LENGTH_SHORT).show();
                        if (getView() != null)
                            getView().hideLoadingIndicator();
                    }
                });
            } else {
                DialogUtil.showNoNetworkAlert(context);
            }
        } catch (Exception e) {
            LogUtils.logE("updateProfile: Exception" + e.getMessage());
            LogUtils.logE(e.toString());
        }


    }

    @Override
    public void getPinCodeData(final Context context, String pinCode) {
        try {


            if (Connectivity.isConnected(context)) {
                LogUtils.logE("run: INSIDE API");

                GetDataService apiService = RetrofitClientInstance.getRetrofitInstanceEternal(context.getString(R.string.bot_api_external)).create(GetDataService.class);
                Call<AddressFromPinCode> call = apiService.getPincodeData(pinCode);
                call.enqueue(new Callback<AddressFromPinCode>() {
                    @Override
                    public void onResponse(Call<AddressFromPinCode> call, Response<AddressFromPinCode> response) {
                        if (response != null) {
                            if (response.body() != null) {
                                if (response.body().s == 1) {
                                    PinCodeAddress pinCodeAddress = response.body().d;
                                    getView().getAddressFromPinCodeSuccess(pinCodeAddress);
                                } else if (response.body().s == 0) {
                                    getView().getAddressFromPinCodeFailure(response.body().m);
                                }
                            } else {
                                getView().getAddressFromPinCodeFailure("pincode not found");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AddressFromPinCode> call, Throwable t) {
                        getView().getAddressFromPinCodeFailure("pincode not found");
                        if (t != null) {
                            getView().getAddressFromPinCodeFailure("Pincode is incorrect try again, please enter correct pin address");
                        } else {
                            getView().getAddressFromPinCodeFailure("pincode not found");

                        }
                    }
                });

            } else {
                DialogUtil.showNoNetworkAlert(context);
            }
        } catch (Exception e) {
            getView().getAddressFromPinCodeFailure("pincode not found");

        }
    }


}






