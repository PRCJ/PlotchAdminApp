package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Promotion implements Serializable {
    @SerializedName("typeId")
    private String typeId;
    @SerializedName("isBogo")
    private int isBogo;
    @SerializedName("apiType")
    private String apiType;
    @SerializedName("linkText")
    private String linkText;
    @SerializedName("targetUrl")
    private String targetUrl;
    @SerializedName("promText")
    private String promText;

    public String getTypeId() {
        return this.typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getIsBogo() {
        return this.isBogo;
    }

    public void setIsBogo(int isBogo) {
        this.isBogo = isBogo;
    }

    public String getApiType() {
        return this.apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getPromText() {
        return this.promText;
    }

    public void setPromText(String promText) {
        this.promText = promText;
    }
}
