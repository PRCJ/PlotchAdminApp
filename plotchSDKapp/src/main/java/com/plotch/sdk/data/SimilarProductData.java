package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class SimilarProductData implements Serializable {

    @SerializedName("similarityIndex")
    int similarityIndex;
    @SerializedName("isInStock")
    String isInStock;
    @SerializedName("vendorUrl")
    String vendorUrl;
    @SerializedName("name")
    String name;
    @SerializedName("vendorPincode")
    String vendorPincode;
    @SerializedName("image")
    String image;
    @SerializedName("discountEndDate")
    String discountEndDate;
    @SerializedName("vendorCod")
    String vendorCod;
    @SerializedName("productCount")
    String productCount;
    @SerializedName("entityId")
    String entityId;
    @SerializedName("vendorName")
    String vendorName;
    @SerializedName("discountStartDate")
    String discountStartDate;
    @SerializedName("urlPath")
    String urlPath;
    @SerializedName("discountedPrice")
    int discountedPrice;
    @SerializedName("internationalShippingCost")
    String internationalShippingCost;
    @SerializedName("price")
    String price;
    @SerializedName("discountPercentage")
    Double discountPercentage;
    @SerializedName("variantId")
    String variantId;
    @SerializedName("buyProductOptionId")
    int buyProductOptionId;
    @SerializedName("discountPercentagw")
    int discountPercentagw;
    @SerializedName("variants")
    ArrayList<Variants> variants;


    public ArrayList<Variants> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<Variants> variants) {
        this.variants = variants;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public int getSimilarityIndex() {
        return similarityIndex;
    }

    public void setSimilarityIndex(int similarityIndex) {
        this.similarityIndex = similarityIndex;
    }

    public String getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(String isInStock) {
        this.isInStock = isInStock;
    }

    public String getVendorUrl() {
        return vendorUrl;
    }

    public void setVendorUrl(String vendorUrl) {
        this.vendorUrl = vendorUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorPincode() {
        return vendorPincode;
    }

    public void setVendorPincode(String vendorPincode) {
        this.vendorPincode = vendorPincode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public String getVendorCod() {
        return vendorCod;
    }

    public void setVendorCod(String vendorCod) {
        this.vendorCod = vendorCod;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getInternationalShippingCost() {
        return internationalShippingCost;
    }

    public void setInternationalShippingCost(String internationalShippingCost) {
        this.internationalShippingCost = internationalShippingCost;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public int getBuyProductOptionId() {
        return buyProductOptionId;
    }

    public void setBuyProductOptionId(int buyProductOptionId) {
        this.buyProductOptionId = buyProductOptionId;
    }

    public int getDiscountPercentagw() {
        return discountPercentagw;
    }

    public void setDiscountPercentagw(int discountPercentagw) {
        this.discountPercentagw = discountPercentagw;
    }


}
