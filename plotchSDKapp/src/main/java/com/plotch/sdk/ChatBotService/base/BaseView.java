package com.plotch.sdk.ChatBotService.base;

import androidx.annotation.StringRes;

public interface BaseView extends MvpView {

    void showMessage(String message);

    void showMessage(@StringRes int resId);

}
