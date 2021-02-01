package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Statements implements Serializable {

    @SerializedName("statementEnglish")
    public String messageEnglish;
    @SerializedName("statementHindi")
    public String messageHindi;
    @SerializedName("type")
    public String type;
    @SerializedName("timeStamp")
    public long timestamp;
    @SerializedName("optionId")
    public int tag;
    @SerializedName("imageUrl")
    public String imageUrl;

    public SimilarProductData spd;
    public OrdersInChat oic;

    public SimilarProductData getSpd() {
        return spd;
    }

    public void setSpd(SimilarProductData spd) {
        this.spd = spd;
    }

    public OrdersInChat getOic() {
        return oic;
    }

    public void setOic(OrdersInChat oic) {
        this.oic = oic;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getMessageEnglish() {
        return messageEnglish;
    }

    public void setMessageEnglish(String messageEnglish) {
        this.messageEnglish = messageEnglish;
    }

    public String getMessageHindi() {
        return messageHindi;
    }

    public void setMessageHindi(String messageHindi) {
        this.messageHindi = messageHindi;
    }
}
