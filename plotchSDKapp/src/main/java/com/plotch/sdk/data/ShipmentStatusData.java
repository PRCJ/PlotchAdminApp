package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class ShipmentStatusData {

    @SerializedName("placedOn")
    public String placedOn;

    @SerializedName("shipmentStatus")
    public String shipmentStatus;

    @SerializedName("shipmentId")
    public String shipmentId;

    @SerializedName("dateStatus")
    public String dateStatus;

    @SerializedName("message")
    public String message;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("amountTitle")
    public String amountTitel;

    @SerializedName("productName")
    public String productName;

    @SerializedName("orderId")
    public String orderId;

    @SerializedName("productImageURL")
    public String productImageURL;

    @SerializedName("price")
    public int price;

    @SerializedName("entityId")
    public int entityId;

    @SerializedName("method")
    public String method;

    @SerializedName("productId")
    public long productId;
}
