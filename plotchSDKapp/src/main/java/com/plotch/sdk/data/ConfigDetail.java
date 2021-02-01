package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConfigDetail implements Serializable {

    @SerializedName("chatbotName")
    private String chatbotName;
    @SerializedName("chatbotImage")
    private String chatbotImage;
    @SerializedName("chatbotDescription")
    private String chatbotDescription;
    @SerializedName("defaultPrimaryColor")
    private String defaultPrimaryColor;

    public String getChatbotName() {
        return chatbotName;
    }

    public void setChatbotName(String chatbotName) {
        this.chatbotName = chatbotName;
    }

    public String getChatbotImage() {
        return chatbotImage;
    }

    public void setChatbotImage(String chatbotImage) {
        this.chatbotImage = chatbotImage;
    }

    public String getChatbotDescription() {
        return chatbotDescription;
    }

    public void setChatbotDescription(String chatbotDescription) {
        this.chatbotDescription = chatbotDescription;
    }

    public String getDefaultPrimaryColor() {
        return defaultPrimaryColor;
    }

    public void setDefaultPrimaryColor(String defaultPrimaryColor) {
        this.defaultPrimaryColor = defaultPrimaryColor;
    }


}
