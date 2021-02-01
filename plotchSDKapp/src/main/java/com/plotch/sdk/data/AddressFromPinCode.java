package com.plotch.sdk.data;

/**
 * Created by naresh on 18/8/16.
 */

import com.google.gson.annotations.SerializedName;

/**
 * Created by surajbokankar on 18/08/16.
 */

public class AddressFromPinCode {

    @SerializedName("d")
    public PinCodeAddress d;
    @SerializedName("m")
    public String m;
    @SerializedName("s")
    public Integer s;
}
