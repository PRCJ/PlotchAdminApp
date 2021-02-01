package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

public class PurchaseData {

    @SerializedName("walletInformation")
    private WalletInformationData walletInformation;
    @SerializedName("cartDetails")
    private CartDetails cartDetails;
    @SerializedName("address")
    private AddressListData addressList;
    @SerializedName("paymentMode")
    private String paymentMode;

    public WalletInformationData getWalletInformation() {
        return walletInformation;
    }

    public void setWalletInformation(WalletInformationData walletInformation) {
        this.walletInformation = walletInformation;
    }

    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }

    public AddressListData getAddressList() {
        return addressList;
    }

    public void setAddressList(AddressListData addressList) {
        this.addressList = addressList;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

}
