package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class CodOrderPlacedDetails {
    @SerializedName("orderId")
    private String orderId;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("paymentMode")
    private String paymentMode;
    @SerializedName("customerEmail")
    private String customerEmail;
    @SerializedName("orderPlacedOn")
    private String orderPlacedOn;
    @SerializedName("customerMobile")
    private String customerMobile;
    @SerializedName("orderDeliveryExpectedDate")
    private String orderDeliveryExpectedDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrderPlacedOn() {
        return orderPlacedOn;
    }

    public void setOrderPlacedOn(String orderPlacedOn) {
        this.orderPlacedOn = orderPlacedOn;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getOrderDeliveryExpectedDate() {
        return orderDeliveryExpectedDate;
    }

    public void setOrderDeliveryExpectedDate(String orderDeliveryExpectedDate) {
        this.orderDeliveryExpectedDate = orderDeliveryExpectedDate;
    }


}
