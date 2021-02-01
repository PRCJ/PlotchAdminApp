package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FaqQuestions implements Serializable {

    @SerializedName("faq_question")
    private String faq_question;

    @SerializedName("tag")
    private String tag;
}
