package com.plotch.sdk.ChatBotService.base;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

}
