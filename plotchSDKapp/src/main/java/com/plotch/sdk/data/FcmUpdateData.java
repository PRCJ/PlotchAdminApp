package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class FcmUpdateData {
    @SerializedName("s")
    public Integer s;
    @SerializedName("m")
    public String m;
    @SerializedName("d")
    public Object d;

    @Override
    public String toString() {
        return "ChatBotResponse{" +
                "s=" + s +
                ", m='" + m + '\'' +
                ", d=" + d +
                '}';
    }
}
