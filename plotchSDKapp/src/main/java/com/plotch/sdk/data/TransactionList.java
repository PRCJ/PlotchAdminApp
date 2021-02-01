package com.plotch.sdk.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionList {

    @SerializedName("orderId")
    @Expose
    public String orderId;

    @SerializedName("amount")
    @Expose
    public int amount;

    @SerializedName("createdAt")
    @Expose
    public String createdAt;

    @SerializedName("expiryDate")
    @Expose
    public String expiryDate;

    @SerializedName("remark")
    @Expose
    public String remark;

    @SerializedName("amountType")
    @Expose
    public String amountType;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getExpiryData() {
        return expiryDate;
    }

    public void setExpiryData(String expiryData) {
        this.expiryDate = expiryData;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }


}
