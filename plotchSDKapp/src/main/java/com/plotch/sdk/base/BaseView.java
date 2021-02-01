package com.plotch.sdk.base;

import androidx.annotation.StringRes;

public interface BaseView extends MvpView {

    void showMessage(String message);

    void showMessage(@StringRes int resId);

}
