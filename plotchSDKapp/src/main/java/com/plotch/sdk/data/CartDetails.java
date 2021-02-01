package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class CartDetails implements Serializable {
    @SerializedName("coupon")
    private Coupon coupon;
    @SerializedName("products")
    private ArrayList<Products> products;
    @SerializedName("displayMsg")
    private String displayMsg;
    @SerializedName("orderSummary")
    private OrderSummary orderSummary;

    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public ArrayList<Products> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public String getDisplayMsg() {
        return this.displayMsg;
    }

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    public OrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public void setOrderSummary(OrderSummary orderSummary) {
        this.orderSummary = orderSummary;
    }
}
