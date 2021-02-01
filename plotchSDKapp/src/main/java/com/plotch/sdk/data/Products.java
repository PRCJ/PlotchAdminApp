package com.plotch.sdk.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {

    @SerializedName("isInStock")
    private int isInStock;
    @SerializedName("entity_id")
    private int entityId;
    @SerializedName("sub_category_id")
    private int subCategoryId;
    @SerializedName("tags")
    private ArrayList<String> tags;
    @SerializedName("isCod")
    private int isCod;
    @SerializedName("tax")
    private double tax;
    @SerializedName("qty")
    private int qty;
    @SerializedName("productUrl")
    private String productUrl;
    @SerializedName("variants")
    private Variant variants;
    @SerializedName("productName")
    private String productName;
    @SerializedName("discountAmount")
    private int discountAmount;
    @SerializedName("regularPrice")
    private int regularPrice;
    @SerializedName("discountPercentage")
    private int discountPercentage;
    @SerializedName("discountedPrice")
    private String discountedPrice;
    @SerializedName("promotion")
    private Promotion promotion;
    @SerializedName("gst_value")
    private double gstValue;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("productId")
    private String productId;

    @SerializedName("shippingcost")
    private String shippingcost;
    @SerializedName("vendorDetails")
    private VendorDetails vendorDetails;
    @SerializedName("size")
    private String size;
    @SerializedName("category")
    private String category;
    @SerializedName("ean")
    private String ean;
    @SerializedName("tp")
    private String tp;
    @SerializedName("categoryId")
    private int categoryId;
    @SerializedName("sku")
    private String sku;
    @SerializedName("hsn")
    private String hsn;
    @SerializedName("itemsCount")
    private int itemsCount;
    @SerializedName("itemsQty")
    private int itemsQty;


    public int getIsInStock() {
        return this.isInStock;
    }

    public void setIsInStock(int isInStock) {
        this.isInStock = isInStock;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(int subCategoryCd) {
        this.subCategoryId = subCategoryId;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getIsCod() {
        return this.isCod;
    }

    public void setIsCod(int isCod) {
        this.isCod = isCod;
    }

    public double getTax() {
        return this.tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductUrl() {
        return this.productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Variant getVariant() {
        return this.variants;
    }

    public void setVariant(Variant variant) {
        this.variants = variant;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getRegularPrice() {
        return this.regularPrice;
    }

    public void setRegularPrice(int regularPrice) {
        this.regularPrice = regularPrice;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Promotion getPromotion() {
        return this.promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public double getGstValue() {
        return this.gstValue;
    }

    public void setGstValue(int gstValue) {
        this.gstValue = gstValue;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
