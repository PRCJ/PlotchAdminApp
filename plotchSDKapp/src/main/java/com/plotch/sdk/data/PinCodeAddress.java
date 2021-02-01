package com.plotch.sdk.data;

/**
 * Created by naresh on 18/8/16.
 */

import com.google.gson.annotations.SerializedName;


public class PinCodeAddress {
    @SerializedName("city")
    public String city;
    @SerializedName("pincode")
    public String pincode;
    @SerializedName("state")
    public String state;
}
