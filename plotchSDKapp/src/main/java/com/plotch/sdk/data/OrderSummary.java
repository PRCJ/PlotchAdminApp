package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderSummary implements Serializable {

    @SerializedName("totalPayable")
    private int totalPayable;
    @SerializedName("totalPaybleAfterWalletDeduct")
    private int totalPaybleAfterWalletDeduct;
    @SerializedName("couponDiscount")
    private int couponDiscount;
    @SerializedName("totalWithoutTax")
    private int totalWithoutTax;
    @SerializedName("discount")
    private int discount;
    @SerializedName("displayTotal")
    private String displayTotal;
    @SerializedName("tax")
    private String tax;
    @SerializedName("total")
    private int total;
    @SerializedName("subTotal")
    private int subTotal;
    @SerializedName("shippingCost")
    private int shippingCost;
    @SerializedName("vat")
    private int vat;
    @SerializedName("itemsCount")
    private int itemsCount;
    @SerializedName("itemsQty")
    private int itemsQty;


    public int getTotalPayable() {
        return this.totalPayable;
    }

    public void setTotalPayable(int totalPayable) {
        this.totalPayable = totalPayable;
    }

    public int getCouponDiscount() {
        return this.couponDiscount;
    }

    public void setCouponDiscount(int couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public int getTotalWithoutTax() {
        return this.totalWithoutTax;
    }

    public void setTotalWithoutTax(int totalWithoutTax) {
        this.totalWithoutTax = totalWithoutTax;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDisplayTotal() {
        return this.displayTotal;
    }

    public void setDisplayTotal(String displayTotal) {
        this.displayTotal = displayTotal;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getShippingCost() {
        return this.shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getVat() {
        return this.vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getTotalPaybleAfterWalletDeduct() {
        return totalPaybleAfterWalletDeduct;
    }

    public void setTotalPaybleAfterWalletDeduct(int totalPaybleAfterWalletDeduct) {
        this.totalPaybleAfterWalletDeduct = totalPaybleAfterWalletDeduct;
    }

}
