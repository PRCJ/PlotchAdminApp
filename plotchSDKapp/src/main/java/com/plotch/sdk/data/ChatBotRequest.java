package com.plotch.sdk.data;


import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class ChatBotRequest {
    @Nullable
    @SerializedName("customerId")
    String customerId;
    @Nullable
    @SerializedName("optionId")
    int tag;
    @Nullable
    @SerializedName("shipmentId")
    String shipmentId;
    @Nullable
    @SerializedName("language")
    String language;
    @Nullable
    @SerializedName("search")
    String extraText;
    @Nullable
    @SerializedName("productId")
    String productId;
    @Nullable
    @SerializedName("extraData")
    String extraData;
    @Nullable
    @SerializedName("purchaseData")
    PurchaseData purchaseData;
    @Nullable
    @SerializedName("chatbotInstanceId")
    String chatbotInstanceId;
    @Nullable
    @SerializedName("botSessionId")
    String botSessionId;
    @Nullable
    @SerializedName("eventTime")
    String eventTime;
    @Nullable
    @SerializedName("medium")
    String medium;

    @Nullable
    @SerializedName("accountId")
    int accountId;

    @Nullable
    @SerializedName("cancellationReasonId")
    int cancellationReasonId;

    public String getBotSessionId() {
        return botSessionId;
    }

    public void setBotSessionId(String botSessionId) {
        this.botSessionId = botSessionId;
    }


    public int getCancellationReasonId() {
        return cancellationReasonId;
    }

    public void setCancellationReasonId(int cancellationReasonId) {
        this.cancellationReasonId = cancellationReasonId;
    }

    public String getChatbotInstanceId() {
        return chatbotInstanceId;
    }

    public void setChatbotInstanceId(String chatbotInstanceId) {
        this.chatbotInstanceId = chatbotInstanceId;
    }


    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


    public PurchaseData getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getExtraText() {
        return extraText;
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
