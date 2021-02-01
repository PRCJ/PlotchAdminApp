package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConfigData implements Serializable {

    @SerializedName("s")
    public Integer s;
    @SerializedName("m")
    public String m;
    @SerializedName("d")
    public ConfigDetail d;

    @Override
    public String toString() {
        return "ChatBotData{" +
                "s=" + s +
                ", m='" + m + '\'' +
                ", d=" + d +
                '}';
    }
}


