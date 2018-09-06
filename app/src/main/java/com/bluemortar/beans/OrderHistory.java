package com.bluemortar.beans;

/**
 * Created by Syacraft on 22-Sep-16.
 */
public class OrderHistory {

    private String productName;
    private String productInfo;
    private String productLocation;
    private String productPrice;

    public OrderHistory(String productName, String productInfo, String productLocation, String productPrice) {
        this.productName = productName;
        this.productInfo = productInfo;
        this.productLocation = productLocation;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
