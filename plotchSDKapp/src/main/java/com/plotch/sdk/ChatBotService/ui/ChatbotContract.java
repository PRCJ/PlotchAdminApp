package com.plotch.sdk.ChatBotService.ui;

import android.content.Context;

import com.plotch.sdk.ChatBotService.base.BaseView;
import com.plotch.sdk.data.ChatBotRequest;
import com.plotch.sdk.data.ChatBotResponse;
import com.plotch.sdk.data.FcmUpdateData;
import com.plotch.sdk.data.PinCodeAddress;


public class ChatbotContract {

    public interface View extends BaseView {
        void setChatBotResponse(ChatBotResponse data);

        void getAddressFromPinCodeSuccess(PinCodeAddress pinCodeAddress);

        void getAddressFromPinCodeFailure(String errorMessage);

        void setChatBot(FcmUpdateData response, boolean b, String s);
    }

    public interface Presenter {
        void getChatData(Context context, ChatBotRequest cbr);

        void getPinCodeData(Context context, String pinCode);


    }
}
