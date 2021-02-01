package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class FcmRequest {

    @SerializedName("chatbotInstanceId")
    String chatbotInstanceId;
    @SerializedName("notificationInstanceId")
    String notificationInstanceId;
    @SerializedName("firebaseToken")
    String firebaseToken;
    @SerializedName("firebaseInstance")
    String firebaseInstance;

    public String getChatbotInstanceId() {
        return chatbotInstanceId;
    }

    public void setChatbotInstanceId(String chatbotInstanceId) {
        this.chatbotInstanceId = chatbotInstanceId;
    }

    public String getNotificationInstanceId() {
        return notificationInstanceId;
    }

    public void setNotificationInstanceId(String notificationInstanceId) {
        this.notificationInstanceId = notificationInstanceId;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getFirebaseInstance() {
        return firebaseInstance;
    }

    public void setFirebaseInstance(String firebaseInstance) {
        this.firebaseInstance = firebaseInstance;
    }


}
