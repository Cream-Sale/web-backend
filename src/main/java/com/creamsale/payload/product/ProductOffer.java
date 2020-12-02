package com.creamsale.payload.product;

public class ProductOffer {

    private final String productName;
    private final String productImg;
    private final String price;
    private final String priceWithSale;
    private final String cashBackImg;

    public ProductOffer(String productName, String productImg, String price, String priceWithSale, String cashBackImg) {
        this.productName = productName;
        this.productImg = productImg;
        this.price = price;
        this.priceWithSale = priceWithSale;
        this.cashBackImg = cashBackImg;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceWithSale() {
        return priceWithSale;
    }

    public String getCashBackImg() {
        return cashBackImg;
    }
}
