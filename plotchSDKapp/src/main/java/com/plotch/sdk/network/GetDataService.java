package com.plotch.sdk.network;

import com.plotch.sdk.BuildConfig;
import com.plotch.sdk.data.AddressFromPinCode;
import com.plotch.sdk.data.ChatBotRequest;
import com.plotch.sdk.data.ChatBotResponse;
import com.plotch.sdk.data.ConfigData;
import com.plotch.sdk.data.FcmRequest;
import com.plotch.sdk.data.FcmUpdateData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface GetDataService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
            "X-Client: Android",
            "Cache-Control: no-cache",
            "X-VERSION-CODE:" + BuildConfig.VERSION_CODE
    })
    @POST(URLConstants.GET_CHAT_RESPONSE)
    Call<ChatBotResponse> getChatData(@Header("Authorization") String accesstoken, @Header("PlotchSecretKey") String PlotchSecretKey, @Body ChatBotRequest cbr);

    @POST(URLConstants.GET_FCM_UPDATE)
    Call<FcmUpdateData> getFcmDataUpdata(@Body FcmRequest fcmr);

    @GET(URLConstants.GET_CONFIG)
    Call<ConfigData> getConfigDetails(@Query("chatbotInstanceId") String chatbotInstanceId);

    @GET(URLConstants.PINCODE_ADDRESS_CHECK)
    Call<AddressFromPinCode> getPincodeData(@Query("pincode") String pincode);

}

