package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PickupAvailableAt implements Serializable {

    @SerializedName("distance")
    private double distance;
    @SerializedName("name")
    private String name;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("image")
    private String image;
    @SerializedName("hubInstanceId")
    private int hubInstanceId;
    @SerializedName("address")
    private String address;
    @SerializedName("coordinate")
    private String coordinate;

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHubInstanceId() {
        return this.hubInstanceId;
    }

    public void setHubInstanceId(int hubInstanceId) {
        this.hubInstanceId = hubInstanceId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
