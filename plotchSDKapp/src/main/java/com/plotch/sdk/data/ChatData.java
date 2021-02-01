package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatData implements Serializable {

    @SerializedName("faqQuestions")
    private ArrayList<FaqQuestions> faqQuestions;
    @SerializedName("shipments")
    private ArrayList<OrdersInChat> orders;
    @SerializedName("walletDetails")
    private WalletDataForChat walletDetails;
    @SerializedName("products")
    private ArrayList<SimilarProductData> productsList;
    @SerializedName("walletInformation")
    private WalletInformationData walletInformation;
    @SerializedName("cartDetails")
    private CartDetails cartDetails;
    @SerializedName("orderStatusData")
    private ShipmentStatusData orderStatusdata;
    @SerializedName("cancelReasons")
    private ArrayList<CancelReason> cancellationReason;
    @SerializedName("addressList")
    private ArrayList<AddressListData> addressList;

    @SerializedName("codOrderPlacedDetails")
    private CodOrderPlacedDetails codOrderPlacedDetails;

    public CodOrderPlacedDetails getCodOrderPlacedDetails() {
        return codOrderPlacedDetails;
    }

    public void setCodOrderPlacedDetails(CodOrderPlacedDetails codOrderPlacedDetails) {
        this.codOrderPlacedDetails = codOrderPlacedDetails;
    }

    public ShipmentStatusData getOrderStatusdata() {
        return orderStatusdata;
    }

    public void setOrderStatusdata(ShipmentStatusData orderStatusdata) {
        this.orderStatusdata = orderStatusdata;
    }

    public WalletInformationData getWalletInformation() {
        return walletInformation;
    }

    public void setWalletInformation(WalletInformationData walletInformation) {
        this.walletInformation = walletInformation;
    }

    public CartDetails getCartDetails() {
        return this.cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }

    public ArrayList<AddressListData> getAddressList() {
        return this.addressList;
    }

    public void setAddressList(ArrayList<AddressListData> addressList) {
        this.addressList = addressList;
    }

    public WalletDataForChat getWalletDetails() {
        return walletDetails;
    }

    public void setWalletDetails(WalletDataForChat walletDetails) {
        this.walletDetails = walletDetails;
    }

    public ArrayList<FaqQuestions> getFaqQuestions() {
        return faqQuestions;
    }

    public void setFaqQuestions(ArrayList<FaqQuestions> faqQuestions) {
        this.faqQuestions = faqQuestions;
    }

    public ArrayList<OrdersInChat> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<OrdersInChat> orders) {
        this.orders = orders;
    }

    public ArrayList<SimilarProductData> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<SimilarProductData> productsList) {
        this.productsList = productsList;
    }

    public ArrayList<CancelReason> getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(ArrayList<CancelReason> cancellationReason) {
        this.cancellationReason = cancellationReason;
    }


}
