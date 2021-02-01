package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class StatementLang {
    @SerializedName("hindi")
    String hindi;
    @SerializedName("english")
    String english;

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }


}
