package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class VendorDetails implements Serializable {
    @SerializedName("vendorId")
    private String vendorId;
    @SerializedName("vendorPincode")
    private String vendorPincode;
    @SerializedName("vendorCod")
    private int vendorCod;
    @SerializedName("vendorName")
    private int vendorName;
}
