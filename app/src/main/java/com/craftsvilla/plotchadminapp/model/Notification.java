package com.craftsvilla.plotchadminapp.model;

public class Notification {


    int productImage;
    String productName;
    String productOffer;
    String receivedHours;
    String time;
    String shopText;

    public Notification(int productImage, String productName, String productOffer, String receivedHours, String time, String shopText) {
        this.productImage = productImage;
        this.productName = productName;
        this.productOffer = productOffer;
        this.receivedHours = receivedHours;
        this.time = time;
        this.shopText = shopText;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOffer() {
        return productOffer;
    }

    public void setProductOffer(String productOffer) {
        this.productOffer = productOffer;
    }

    public String getReceivedHours() {
        return receivedHours;
    }

    public void setReceivedHours(String receivedHours) {
        this.receivedHours = receivedHours;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShopText() {
        return shopText;
    }

    public void setShopText(String shopText) {
        this.shopText = shopText;
    }
}
