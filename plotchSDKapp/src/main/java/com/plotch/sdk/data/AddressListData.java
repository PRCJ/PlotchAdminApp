package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddressListData implements Serializable {

    @SerializedName("city")
    private String city;
    @SerializedName("countryId")
    private String countryId;
    @SerializedName("addressId")
    private String addressId;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("street")
    private String street;
    @SerializedName("postcode")
    private String postcode;
    @SerializedName("region")
    private String region;
    @SerializedName("countryPhoneCode")
    private String countryPhoneCode;
    @SerializedName("telephone")
    private String telephone;
    @SerializedName("customerId")
    private String customerId;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountryPhoneCode(String countryPhoneCode) {
        this.countryPhoneCode = countryPhoneCode;
    }

    public String getCountryPhoneCode() {
        return countryPhoneCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


}
