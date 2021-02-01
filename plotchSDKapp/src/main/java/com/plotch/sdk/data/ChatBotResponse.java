package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class ChatBotResponse {
    @SerializedName("s")
    public Integer s;
    @SerializedName("m")
    public String m;
    @SerializedName("d")
    public ChatResponseData d;

    @Override
    public String toString() {
        return "ChatBotResponse{" +
                "s=" + s +
                ", m='" + m + '\'' +
                ", d=" + d +
                '}';
    }
}


