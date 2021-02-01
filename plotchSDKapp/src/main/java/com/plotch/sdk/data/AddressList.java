package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressList implements Serializable {
    @SerializedName("city")
    private String city;
    @SerializedName("countryId")
    private String countryId;
    @SerializedName("addressId")
    private String addressId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("defaultAddress")
    private int defaultAddress;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("address")
    private String address;
    @SerializedName("pincode")
    private String pincode;
    @SerializedName("pickupAvailableAt")
    private ArrayList<PickupAvailableAt> pickupAvailableAt;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("countryPhoneCode")
    private String countryPhoneCode;
    @SerializedName("phoneNo")
    private String phoneNo;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getDefaultAddress() {
        return this.defaultAddress;
    }

    public void setDefaultAddress(int defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public ArrayList<PickupAvailableAt> getPickupAvailableAt() {
        return this.pickupAvailableAt;
    }

    public void setPickupAvailableAt(ArrayList<PickupAvailableAt> pickupAvailableAt) {
        this.pickupAvailableAt = pickupAvailableAt;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryPhoneCode() {
        return this.countryPhoneCode;
    }

    public void setCountryPhoneCode(String countryPhoneCode) {
        this.countryPhoneCode = countryPhoneCode;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
