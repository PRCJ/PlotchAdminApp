package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrdersInChat implements Serializable {

    @SerializedName("status")
    private String status;
    @SerializedName("image")
    private String image;
    @SerializedName("name")
    private String name;
    @SerializedName("shipmentId")
    private String shipmentId;
    @SerializedName("price")
    private int price;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("orderId")
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


}
