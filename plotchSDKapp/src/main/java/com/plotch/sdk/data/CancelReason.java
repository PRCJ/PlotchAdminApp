package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class CancelReason {
    @SerializedName("reasonId")
    private int id;
    @SerializedName("reason")
    private String displayText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
