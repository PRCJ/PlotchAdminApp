package com.plotch.sdk.base;

public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

}
